package com.example.blindaidkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.databinding.ViewHolderContactDetailsBinding

class ContactDetailsAdapter() :
    RecyclerView.Adapter<ContactDetailsAdapter.ContactDetailsViewHolder>() {

    private var contactDetailsList: ArrayList<ContactDetails> = ArrayList()

    fun updateData(contactDetails: ContactDetails) {
        contactDetailsList.add(contactDetails)
        notifyDataSetChanged()
    }

    fun setData(contactDetailsList: List<ContactDetails>) {
        this.contactDetailsList = contactDetailsList as ArrayList<ContactDetails>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactDetailsViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_contact_details, parent, false)
        val contactDetailsViewHolder = ContactDetailsViewHolder(view)
        return contactDetailsViewHolder
    }

    override fun onBindViewHolder(holder: ContactDetailsViewHolder, position: Int) {
        holder.viewHolderTextViewName.text = contactDetailsList[position].name
        holder.viewHolderTextViewPhone.text = contactDetailsList[position].phone
    }

    override fun getItemCount(): Int {
        return contactDetailsList.size
    }

    inner class ContactDetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val viewHolderContactDetailsBinding: ViewHolderContactDetailsBinding =
            ViewHolderContactDetailsBinding.bind(view)

        val viewHolderTextViewName = viewHolderContactDetailsBinding.viewholderTextviewName
        val viewHolderTextViewPhone = viewHolderContactDetailsBinding.viewholderTextviewPhone


    }
}