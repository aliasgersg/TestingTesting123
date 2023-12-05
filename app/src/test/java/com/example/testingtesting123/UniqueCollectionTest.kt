package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert(collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) { "Items not cleared" }
    }

    @Test
    fun removeAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))
        collection.addItem(Item("item3"))

        val originalSize = collection.size()
        collection.remove(Item("item2")) // Remove an item

        val newSize = collection.size()
        val isItem2Present = collection.get(0).name.equals("item2", ignoreCase = true) ||
                collection.get(1).name.equals("item2", ignoreCase = true)

        assertTrue("Size did not decrease after removal", originalSize - newSize == 2)
        assertFalse("Item 'item2' was not removed", isItem2Present)
    }
}
// identify and create tests for certain artifacts in the assignemnt 10 video, youre not supposed to test activites, things like book list or book, TEST FOR PART THAT CALCULATES HOW FAR IT REWINDS