package com.abcnv.nvone.lib_base.adapter2


/**
 *     val dataList = mutableListOf<NvAdapterEntity>()
 *     val layoutIdList = mutableListOf<Int>()
 *     val adapter = NvAdapterMultiple<NvAdapterEntity>(dataList, layoutIdList) { viewHolder, itemData ->
 *         when (itemData.type) {
 *             0 -> {
 *                 val tv_name = viewHolder.getView<TextView>(R.id.tv_name)
 *                 tv_name.text = "No.${itemData.index}"
 *             }
 *             1 -> {
 *
 *             }
 *         }
 *     }
 *     rv.setAdapter(adapter)
 *     adapter.setData(data)
 *     adapter.notifyDataSetChanged()
 */
class NvAdapterMultiple<T : NvAdapterEntity>(
    val mLayoutIdList: List<Int>,
    val mItemHandler: (NvViewHolderCallback, T) -> Unit
) : RecyclerView.Adapter<NvViewHolderCallback>() {
    val mData = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NvViewHolderCallback {
        val layout = mLayoutIdList[viewType]
        val layoutInflater = LayoutInflater.from(parent.context);
        val view = layoutInflater.inflate(layout, parent, false)
        return NvViewHolderCallback(view)
    }

    override fun getItemViewType(position: Int): Int {
        return mData[position].type
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: NvViewHolderCallback, position: Int) {
        mItemHandler.invoke(holder, mData[position])
    }
}