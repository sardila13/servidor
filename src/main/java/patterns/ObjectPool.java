/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package patterns;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author ba.bohorquez10
 */
public abstract class ObjectPool<T>
{
    private long tiempoExp;
    
    private Hashtable<T, Long> locked;
    
    private Hashtable<T, Long> unlocked;
    
    protected abstract T create();
    
    public abstract boolean validate(T obj);
    
    public abstract void expire(T obj);
    
    public ObjectPool()
    {
        tiempoExp = 30000; // 30 segundos.
        locked = new Hashtable<T, Long>();
        unlocked = new Hashtable<T, Long>();
    }
    
    public synchronized T checkOut()
    {
        long t1 = System.currentTimeMillis();
        
        T elem = null;
        
        if (unlocked.size() > 0)
        {
            Enumeration<T> en = unlocked.keys();
            
            while ( en.hasMoreElements() )
            {
                elem = en.nextElement();
                
                if ( (t1 - unlocked.get(elem) ) > tiempoExp)
                {
                    // object has expired
                    unlocked.remove(elem);
                    expire(elem);
                    elem = null;
                }
                else
                {
                    if ( validate(elem) )
                    {
                        unlocked.remove(elem);
                        locked.put(elem, t1);
                        
                        return elem;
                    }
                    else
                    {
                        // object failed validation
                        unlocked.remove(elem);
                        expire(elem);
                        elem = null;
                    }
                }
            }
        }
        
        // no objects available, create a new one
        elem = create();
        locked.put(elem, t1);
        
        return (elem);
    }
    
    public synchronized void checkIn(T obj)
    {
        locked.remove(obj);
        unlocked.put( obj, System.currentTimeMillis() );
    }
    
}
