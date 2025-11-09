package com.abcnv.nvone.lib_base.adapter2

class NvEntityDiffCallback : DiffUtil.ItemCallback<NvAdapterEntity>() {
    override fun areItemsTheSame(old: NvAdapterEntity, new: NvAdapterEntity): Boolean {
        return old == new
    }

    override fun areContentsTheSame(old: NvAdapterEntity, new: NvAdapterEntity): Boolean {
        return old.uuid == new.uuid
    }
}