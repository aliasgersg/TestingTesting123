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
        val newSize = collection.size()

        assert(originalSize == 2 && newSize == 0) { "Items not cleared" }
    }

    @Test
    fun removeAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2")) // Use consistent naming
        collection.addItem(Item("item3"))

        val originalSize = collection.size()
        collection.remove(Item("item2")) // Remove 'item2'

        val newSize = collection.size()
        val isItem2Removed = (newSize == originalSize - 1) &&
                !collection.get(0).name.equals("item2", ignoreCase = true) &&
                !collection.get(1).name.equals("item2", ignoreCase = true)

        assertTrue("Item 'item2' was not removed correctly", isItem2Removed)
    }
}
// identify and create tests for certain artifacts in the assignemnt 10 video, youre not supposed to test activites, things like book list or book, TEST FOR PART THAT CALCULATES HOW FAR IT REWINDS