package com.abcnv.nvone.lib_base.adapter2

/**
 *     val diffUtil = EntityDiffCallback()
 *     val layoutIdList = mutableListOf<Int>()
 *     val adapter = NvListAdapterMultiple<NvAdapterEntity>(diffUtil, layoutIdList) { viewHolder, itemData ->
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
 *     adapter.submitList(listOf())
 *     adapter.notifyDataSetChanged()
 */
class NvListAdapterMultiple<T:NvAdapterEntity>(
    itemCallback: DiffUtil.ItemCallback<T>,
    val mLayoutIdList: List<Int>,
    val mItemHandler: (NvViewHolderCallback, T) -> Unit
) : ListAdapter<T, NvViewHolderCallback>(itemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NvViewHolderCallback {
        val layout = mLayoutIdList[viewType]
        val layoutInflater = LayoutInflater.from(parent.context);
        val view = layoutInflater.inflate(layout, parent, false)
        return NvViewHolderCallback(view)
    }
    override fun getItemViewType(position: Int): Int {
        return getItem( position).type
    }

    override fun onBindViewHolder(holder: NvViewHolderCallback, position: Int) {
        mItemHandler(holder, getItem(position))
    }
}