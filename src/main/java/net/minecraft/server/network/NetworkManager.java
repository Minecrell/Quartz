/*
 * Quartz
 * Copyright (c) 2015, Minecrell <https://github.com/Minecrell>
 *
 * Based on Sponge and SpongeAPI, licensed under the MIT License (MIT).
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.minecraft.server.network;

import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.server.chat.ChatComponent;
import net.minecraft.server.network.packet.Packet;
import net.minecrell.quartz.launch.mappings.Mapping;
import net.minecrell.quartz.mixin.network.MixinNetworkManager;
import org.spongepowered.api.MinecraftVersion;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

@Mapping("el")
public abstract class NetworkManager extends SimpleChannelInboundHandler<Packet> {

    @Mapping("b")
    public abstract SocketAddress getRemoteAddress();

    @Mapping("a")
    public abstract void sendPacket(Packet packet);

    @Mapping("a")
    public abstract void disconnect(ChatComponent reason);

    public abstract InetSocketAddress getAddress();

    public abstract InetSocketAddress getVirtualHost();

    public abstract void setVirtualHost(String host, int port);

    public abstract MinecraftVersion getVersion();

    public abstract void setVersion(int version);

}
