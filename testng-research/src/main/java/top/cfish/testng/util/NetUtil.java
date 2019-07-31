package top.cfish.testng.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.net.HostAndPort;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/6/12
 * @time: 15:32
 */

@Slf4j
public class NetUtil
{
    private static final String UNKNOWN_LOCALHOST = "UNKNOWN_LOCALHOST";
    
    private static String localHostName = null;
    
    private static String localIp = null;
    
    public static String getLocalHostname()
    {
        if (localHostName != null)
        {
            return localHostName;
        }
        try
        {
            final InetAddress addr = InetAddress.getLocalHost();
            localHostName = addr.getHostName();
            return localHostName;
        }
        catch (final UnknownHostException uhe)
        {
            try
            {
                final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                while (interfaces.hasMoreElements())
                {
                    final NetworkInterface nic = interfaces.nextElement();
                    final Enumeration<InetAddress> addresses = nic.getInetAddresses();
                    while (addresses.hasMoreElements())
                    {
                        final InetAddress address = addresses.nextElement();
                        if (!address.isLoopbackAddress())
                        {
                            final String hostname = address.getHostName();
                            if (hostname != null)
                            {
                                return hostname;
                            }
                        }
                    }
                }
            }
            catch (final SocketException se)
            {
                log.error("Could not determine local host name");
                return UNKNOWN_LOCALHOST;
            }
            log.error("Could not determine local host name");
            return UNKNOWN_LOCALHOST;
        }
    }
    
    public static String getLocalIp()
    {
        if (localIp != null)
        {
            return localIp;
        }
        try
        {
            final InetAddress addr = InetAddress.getLocalHost();
            localIp = addr.getHostAddress();
            return localIp;
        }
        catch (final UnknownHostException uhe)
        {
            try
            {
                final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                while (interfaces.hasMoreElements())
                {
                    final NetworkInterface nic = interfaces.nextElement();
                    final Enumeration<InetAddress> addresses = nic.getInetAddresses();
                    while (addresses.hasMoreElements())
                    {
                        final InetAddress address = addresses.nextElement();
                        if (!address.isLoopbackAddress())
                        {
                            final String hostname = address.getHostName();
                            if (hostname != null)
                            {
                                return hostname;
                            }
                        }
                    }
                }
            }
            catch (final SocketException se)
            {
                log.error("Could not determine local ip address");
                return UNKNOWN_LOCALHOST;
            }
            log.error("Could not determine local ip address");
            return UNKNOWN_LOCALHOST;
        }
    }
    
    public static List<HostAndPort> parseHostAndPort(String host, int defaultPort)
    {
        if (StringUtils.isBlank(host))
        {
            return Collections.emptyList();
        }
        List<String> hostPort = Splitter.on(',').trimResults().omitEmptyStrings().splitToList(host);
        List<HostAndPort> hostPortPairList = Lists.newArrayListWithCapacity(hostPort.size());
        for (String host_port : hostPort)
        {
            hostPortPairList.add(HostAndPort.fromString(host_port).withDefaultPort(defaultPort));
        }
        return hostPortPairList;
    }
}
