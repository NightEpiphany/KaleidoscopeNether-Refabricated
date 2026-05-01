package com.bmt.kaleidoscope_nether.api.event;

import com.github.ysbbbbbb.kaleidoscopecookery.api.event.ActionEvent;
import com.github.ysbbbbbb.kaleidoscopecookery.api.event.IActionCancelable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AnvilUpdateEvent extends ActionEvent implements IActionCancelable {
    private final ItemStack left;
    private final ItemStack right;
    private final String name;
    private ItemStack output;
    private long cost;
    private int materialCost;
    private final Player player;

    public AnvilUpdateEvent(ItemStack left, ItemStack right, String name, long cost, Player player) {
        this.left = left;
        this.right = right;
        this.output = ItemStack.EMPTY;
        this.name = name;
        this.player = player;
        this.setCost(cost);
        this.setMaterialCost(0);
    }


    public ItemStack getLeft() {
        return left;
    }


    public ItemStack getRight() {
        return right;
    }


    @Nullable
    public String getName() {
        return name;
    }


    public ItemStack getOutput() {
        return output;
    }


    public void setOutput(ItemStack output) {
        this.output = output;
    }


    public long getCost() {
        return cost;
    }


    public void setCost(long cost) {
        this.cost = cost;
    }


    public int getMaterialCost() {
        return materialCost;
    }


    public void setMaterialCost(int materialCost) {
        this.materialCost = materialCost;
    }


    public Player getPlayer() {
        return this.player;
    }


    @FunctionalInterface
    public interface AnvilUpdateHandler {
        void onUpdate(AnvilUpdateEvent var1);
    }
}
