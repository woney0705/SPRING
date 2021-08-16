package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void sava() {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item savaItem = itemRepository.sava(item);

        //then
        Item findItem = itemRepository.findById(item.getId());

        assertThat(findItem).isEqualTo(savaItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 30000, 15);
        //when
        itemRepository.sava(item1);
        itemRepository.sava(item2);

        //then
        List<Item> findItem = itemRepository.findAll();

        assertThat(findItem.size()).isEqualTo(2);
    }

    @Test
    void update() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item saveItem = itemRepository.sava(item1);
        Long itemId = saveItem.getId();

        //when
        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(itemId, updateParam);

        //then
        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    }

}