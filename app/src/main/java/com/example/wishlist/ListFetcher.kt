package com.example.wishlist

class ListFetcher {
    companion object {
        fun getList(): MutableList<List> {
            return ArrayList()
        }

        fun addLists (itemName: String, price:String, description:String): MutableList<List> {
            val lists :  MutableList<List> = ArrayList()
            val list = List(itemName, price, description)
            lists.add(list)
            return lists
        }

        fun remove (): MutableList<List> {
            val lists :  MutableList<List> = ArrayList()
            lists.removeAt(1);
//            recycler.removeViewAt(1);
//            mAdapter.notifyItemRemoved(1);
//            mAdapter.notifyItemRangeChanged(1, lists.size());
            return lists
        }

    }
}