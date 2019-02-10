package com.github.misakikoo.misakitools.client;

import com.github.misakikoo.misakitools.item.ItemLoader;
import com.github.misakikoo.misakitools.block.BlockLoader;

public class ItemRenderLoader {
    public ItemRenderLoader() {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}
