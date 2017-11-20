package ut.com.atlassian.plugin.myPlugin;

import org.junit.Test;
import com.atlassian.plugin.myPlugin.api.MyPluginComponent;
import com.atlassian.plugin.myPlugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}