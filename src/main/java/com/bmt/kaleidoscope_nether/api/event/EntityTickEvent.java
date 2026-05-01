package com.bmt.kaleidoscope_nether.api.event;

import com.bmt.kaleidoscope_nether.init.KNEvents;
import com.github.ysbbbbbb.kaleidoscopecookery.api.event.ActionEvent;
import com.github.ysbbbbbb.kaleidoscopecookery.api.event.IActionCancelable;
import net.minecraft.world.entity.Entity;

public class EntityTickEvent extends ActionEvent {
    private final Entity entity;
    protected EntityTickEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }


    public static class Pre extends EntityTickEvent implements IActionCancelable {
        public Pre(Entity entity) {
            super(entity);
        }

        @Override
        public void setCanceled(boolean canceled) {
            IActionCancelable.super.setCanceled(canceled);
        }

        @FunctionalInterface
        public interface PreHandler {
            void pre(EntityTickEvent.Pre event);
        }

        public static EntityTickEvent.Pre fireEntityTickPre(Entity entity) {
            Pre pre = new Pre(entity);
            KNEvents.ENTITY_PRE.invoker().pre(pre);
            return pre;
        }
    }

    public static class Post extends EntityTickEvent {
        public Post(Entity entity) {
            super(entity);
        }

        @FunctionalInterface
        public interface PostHandler {
            void post(EntityTickEvent.Post event);
        }

        public static void fireEntityTickPost(Entity entity) {
            Post post = new Post(entity);
            KNEvents.ENTITY_POST.invoker().post(post);
        }
    }
}
