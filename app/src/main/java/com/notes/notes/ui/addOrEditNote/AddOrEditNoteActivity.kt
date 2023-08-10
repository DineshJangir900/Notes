package com.notes.notes.ui.addOrEditNote

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.notes.notes.R
import com.notes.notes.data.local.roomDb.entity.Note
import com.notes.notes.databinding.ActivityAddOrEditNoteBinding
import com.notes.notes.utils.Constants

class AddOrEditNoteActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityAddOrEditNoteBinding
    private lateinit var mViewModel: AddOrEditNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
        mBinding = ActivityAddOrEditNoteBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()

        if (intent.hasExtra(Constants.ID)) {
            intent?.let {
                Log.e("ddd", " " + intent.getIntExtra(Constants.ID, 0))

                mViewModel.getNoteRecord(intent.getIntExtra(Constants.ID, 0)).observe(this) {
                    it?.let {
                        mBinding.etTitle.setText(it.noteTitle)
                        mBinding.etNote.setText(it.note)
                    }
                }
            }
        }

        //click actions
        mBinding.ivSave.setOnClickListener { saveNote() }
        mBinding.ivBack.setOnClickListener { onBackPressed() }
    }


    //Function ot initialize variables and objects
    private fun init() {
        mViewModel = ViewModelProvider(this).get(AddOrEditNoteViewModel::class.java)
    }


    private fun saveNote() {
        if (mBinding.etTitle.text.isNotEmpty() || mBinding.etNote.text.isNotEmpty()) {

            //saving note
            if (intent.hasExtra(Constants.ID)) {
                intent?.let {
                    mViewModel.saveNote(
                        Note(
                            mBinding.etTitle.text.toString(),
                            mBinding.etNote.text.toString(),
                            System.currentTimeMillis(),
                            intent.getIntExtra(Constants.ID, 0)
                        )
                    )
                }
            } else {
                mViewModel.saveNote(
                    Note(
                        mBinding.etTitle.text.toString(),
                        mBinding.etNote.text.toString(),
                        System.currentTimeMillis()
                    )
                )
            }

            super.onBackPressed()
        }
    }


    override fun onBackPressed() {
        if (mBinding.etTitle.text.isNotEmpty() || mBinding.etNote.text.isNotEmpty()) {
            //saving note using view model
            if (intent.hasExtra(Constants.ID)) {
                intent?.let {
                    mViewModel.saveNote(
                        Note(
                            mBinding.etTitle.text.toString(),
                            mBinding.etNote.text.toString(),
                            System.currentTimeMillis(),
                            intent.getIntExtra(Constants.ID, 0)
                        )
                    )
                }
            } else {
                mViewModel.saveNote(
                    Note(
                        mBinding.etTitle.text.toString(),
                        mBinding.etNote.text.toString(),
                        System.currentTimeMillis()
                    )
                )
            }
        }

        super.onBackPressed()
    }
}