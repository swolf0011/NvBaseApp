package com.abcnv.nvone.lib_base.adapter2

/**
 *     val layoutId:Int = 0
 *     val adapter = NvAdapterOne<NvAdapterEntity>(layoutId) { viewHolder, itemData ->
 *         val tv_name = viewHolder.getView<TextView>(R.id.tv_name)
 *         tv_name.text = "No.${itemData.index}"
 *     }
 *     rv.setAdapter(adapter)
 *     adapter.setData(data)
 *     adapter.notifyDataSetChanged()
 */
class NvAdapterOne<T>(
    val mLayoutId: Int,
    val mItemHandler: (NvViewHolderCallback, T) -> Unit
) : RecyclerView.Adapter<NvViewHolderCallback>() {
    val mData = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NvViewHolderCallback {
        val layoutInflater = LayoutInflater.from(parent.context);
        val view = layoutInflater.inflate(mLayoutId, parent, false)
        return NvViewHolderCallback(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: NvViewHolderCallback, position: Int) {
        mItemHandler.invoke(holder, mData[position])
    }
}