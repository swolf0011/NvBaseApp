package com.abcnv.nvone.lib_base.adapter2

/**
 *     val diffUtil = EntityDiffCallback()
 *     val layoutId:Int = 0
 *     val adapter = NvListAdapterOne<NvAdapterEntity>(diffUtil,layoutId) { viewHolder, itemData ->
 *         val tv_name = viewHolder.getView<TextView>(R.id.tv_name)
 *         tv_name.text = "No.${itemData.index}"
 *     }
 *     rv.setAdapter(adapter)
 *     adapter.submitList(listOf())
 *     adapter.notifyDataSetChanged()
 */
class NvListAdapterOne<T>(
    itemCallback: DiffUtil.ItemCallback<T>,
    val mLayoutId: Int,
    val mItemHandler: (NvViewHolderCallback, T) -> Unit
) : ListAdapter<T, NvViewHolderCallback>(itemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NvViewHolderCallback {
        val li = LayoutInflater.from(parent.context)
        val view = li.inflate(mLayoutId, parent, false)
        return NvViewHolderCallback(view)
    }

    override fun onBindViewHolder(holder: NvViewHolderCallback, position: Int) {
        mItemHandler(holder, getItem(position))
    }
}