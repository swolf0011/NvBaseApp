package com.abcnv.nvone.lib_base.adapter2


class NvViewHolderCallback(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mViews = SparseArray<View>()

    /**
     * 根据id获取控件
     * @param viewId 控件id
     * @return
     */
    fun <T : View> getView(viewId: Int): T {
        var view: View = mViews.get(viewId)
        if (null == view) {
            view = itemView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as T
    }
}