/*
 * Quartz
 * Copyright (c) 2015, Minecrell <https://github.com/Minecrell>
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

package net.minecrell.quartz;

import com.google.common.base.Optional;
import net.minecraft.server.MinecraftServer;
import net.minecrell.quartz.event.QuartzEventManager;
import net.minecrell.quartz.plugin.QuartzPluginManager;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.Platform;
import org.spongepowered.api.Server;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.service.scheduler.AsynchronousScheduler;
import org.spongepowered.api.service.scheduler.SynchronousScheduler;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuartzGame implements Game {

    private static final String API_VERSION = QuartzGame.class.getPackage().getSpecificationVersion();
    private static final String IMPLEMENTATION_VERSION = QuartzGame.class.getPackage().getImplementationVersion();

    private static final MinecraftVersion MINECRAFT_VERSION = new QuartzMinecraftVersion("1.8", 47);

    private final QuartzPluginManager pluginManager;
    private final QuartzEventManager eventManager;
    private final GameRegistry gameRegistry;
    private final ServiceManager serviceManager;

    @Inject
    public QuartzGame(QuartzPluginManager pluginManager, QuartzEventManager eventManager, GameRegistry gameRegistry, ServiceManager serviceManager) {
        this.pluginManager = pluginManager;
        this.eventManager = eventManager;
        this.gameRegistry = gameRegistry;
        this.serviceManager = serviceManager;
    }

    @Override
    public Platform getPlatform() {
        return Platform.SERVER;
    }

    @Override
    public Optional<Server> getServer() {
        return Optional.fromNullable((Server) MinecraftServer.getServer());
    }

    @Override
    public QuartzPluginManager getPluginManager() {
        return pluginManager;
    }

    @Override
    public QuartzEventManager getEventManager() {
        return eventManager;
    }

    @Override
    public GameRegistry getRegistry() {
        return gameRegistry;
    }

    @Override
    public ServiceManager getServiceManager() {
        return serviceManager;
    }

    @Override
    public SynchronousScheduler getSyncScheduler() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public AsynchronousScheduler getAsyncScheduler() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public CommandService getCommandDispatcher() {
        return serviceManager.provideUnchecked(CommandService.class);
    }

    @Override
    public String getApiVersion() {
        return API_VERSION;
    }

    @Override
    public String getImplementationVersion() {
        return IMPLEMENTATION_VERSION;
    }

    @Override
    public MinecraftVersion getMinecraftVersion() {
        return MINECRAFT_VERSION;
    }

}
