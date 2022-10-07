package com.vertodev.virtualkeyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import com.vertodev.virtualkeyboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var caps: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        alphaNumericKeyboard()
        numericKeyboard()

        binding.textClear.setOnClickListener {
            binding.dialogTextField.setText("")
        }

        binding.radioAlphanumeric.isChecked = true
        enableAlphaNumericKeyboard()
    }

    private fun updateText(strToAdd: String, edtText: EditText) {
        val oldStr = edtText.text.toString()
        val cursoPos = edtText.selectionStart
        val leftStr = oldStr.substring(0, cursoPos)
        val rightStr = oldStr.substring(cursoPos)

        edtText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr))
        edtText.setSelection(cursoPos + 1)
    }

    private fun backspaceFunction(edtText: EditText) {
        val cursoPos = edtText.selectionStart
        val textLen = edtText.text.length

        if (cursoPos != 0 && textLen != 0) {
            val selection: SpannableStringBuilder =
                edtText.text as SpannableStringBuilder
            selection.replace(cursoPos - 1, cursoPos, "")
            edtText.text = selection
            edtText.setSelection(cursoPos - 1)
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_alphanumeric ->
                    if (checked) {
                        enableAlphaNumericKeyboard()
                    }
                R.id.radio_numeric ->
                    if (checked) {
                        enableNumericKeyboard()
                    }
            }
        }
    }

    private fun enableNumericKeyboard() {
        with(binding) {
            numericLayout.visibility = View.VISIBLE
            alphanumericLayot.visibility = View.GONE
        }
    }

    private fun enableAlphaNumericKeyboard() {
        with(binding) {
            numericLayout.visibility = View.GONE
            alphanumericLayot.visibility = View.VISIBLE
        }
    }

    private fun alphaNumericKeyboard() {
        with(binding) {
            setNumericButton()
            setAlphaButton()
            setSimbolsButton()

            buttonDel.setOnClickListener {
                backspaceFunction(dialogTextField)
            }
            buttonCaps.setOnClickListener {
                capsFunction()
            }

        }
    }

    private fun numericKeyboard() {
        with(binding) {
            numericButton0.setOnClickListener {
                updateText(getString(R.string.n0), dialogTextField)
            }
            numericButton1.setOnClickListener {
                updateText(getString(R.string.n1), dialogTextField)
            }
            numericButton2.setOnClickListener {
                updateText(getString(R.string.n2), dialogTextField)
            }
            numericButton3.setOnClickListener {
                updateText(getString(R.string.n3), dialogTextField)
            }
            numericButton4.setOnClickListener {
                updateText(getString(R.string.n4), dialogTextField)
            }
            numericButton5.setOnClickListener {
                updateText(getString(R.string.n5), dialogTextField)
            }
            numericButton6.setOnClickListener {
                updateText(getString(R.string.n6), dialogTextField)
            }
            numericButton7.setOnClickListener {
                updateText(getString(R.string.n7), dialogTextField)
            }
            numericButton8.setOnClickListener {
                updateText(getString(R.string.n8), dialogTextField)
            }
            numericButton9.setOnClickListener {
                updateText(getString(R.string.n9), dialogTextField)
            }
            numericButtonP.setOnClickListener {
                updateText(getString(R.string.s_ponto), dialogTextField)
            }
            numericButtonDel.setOnClickListener {
                backspaceFunction(dialogTextField)
            }
        }
    }

    private fun ActivityMainBinding.setSimbolsButton() {
        buttonArroba.setOnClickListener {
            updateText(buttonArroba.text.toString(), dialogTextField)
        }
        buttonPonto.setOnClickListener {
            updateText(buttonPonto.text.toString(), dialogTextField)
        }
        buttonPercent.setOnClickListener {
            updateText(buttonPercent.text.toString(), dialogTextField)
        }
        buttonDoisPontos.setOnClickListener {
            updateText(buttonDoisPontos.text.toString(), dialogTextField)
        }
        buttonTraco.setOnClickListener {
            updateText(buttonTraco.text.toString(), dialogTextField)
        }
        buttonUnderline.setOnClickListener {
            updateText(buttonUnderline.text.toString(), dialogTextField)
        }
        buttonEsclamacao.setOnClickListener {
            updateText(buttonEsclamacao.text.toString(), dialogTextField)
        }
        buttonInterrogacao.setOnClickListener {
            updateText(buttonInterrogacao.text.toString(), dialogTextField)
        }
    }

    private fun ActivityMainBinding.capsFunction() {
        caps = !caps

        buttonA.text = if (caps) getString(R.string.A) else getString(R.string.a)
        buttonB.text = if (caps) getString(R.string.B) else getString(R.string.b)
        buttonC.text = if (caps) getString(R.string.C) else getString(R.string.c)
        buttonD.text = if (caps) getString(R.string.D) else getString(R.string.d)
        buttonE.text = if (caps) getString(R.string.E) else getString(R.string.e)
        buttonF.text = if (caps) getString(R.string.F) else getString(R.string.f)
        buttonG.text = if (caps) getString(R.string.G) else getString(R.string.g)
        buttonH.text = if (caps) getString(R.string.H) else getString(R.string.h)
        buttonI.text = if (caps) getString(R.string.I) else getString(R.string.i)
        buttonJ.text = if (caps) getString(R.string.J) else getString(R.string.j)
        buttonK.text = if (caps) getString(R.string.K) else getString(R.string.k)
        buttonL.text = if (caps) getString(R.string.L) else getString(R.string.l)
        buttonM.text = if (caps) getString(R.string.M) else getString(R.string.m)
        buttonN.text = if (caps) getString(R.string.N) else getString(R.string.n)
        buttonO.text = if (caps) getString(R.string.O) else getString(R.string.o)
        buttonP.text = if (caps) getString(R.string.P) else getString(R.string.p)
        buttonQ.text = if (caps) getString(R.string.Q) else getString(R.string.q)
        buttonR.text = if (caps) getString(R.string.R) else getString(R.string.r)
        buttonS.text = if (caps) getString(R.string.S) else getString(R.string.s)
        buttonT.text = if (caps) getString(R.string.T) else getString(R.string.t)
        buttonU.text = if (caps) getString(R.string.U) else getString(R.string.u)
        buttonV.text = if (caps) getString(R.string.V) else getString(R.string.v)
        buttonX.text = if (caps) getString(R.string.X) else getString(R.string.x)
        buttonW.text = if (caps) getString(R.string.W) else getString(R.string.w)
        buttonY.text = if (caps) getString(R.string.Y) else getString(R.string.y)
        buttonZ.text = if (caps) getString(R.string.Z) else getString(R.string.z)
    }

    private fun ActivityMainBinding.setAlphaButton() {
        buttonA.setOnClickListener {
            updateText(buttonA.text.toString(), dialogTextField)
        }
        buttonB.setOnClickListener {
            updateText(buttonB.text.toString(), dialogTextField)
        }
        buttonC.setOnClickListener {
            updateText(buttonC.text.toString(), dialogTextField)
        }
        buttonD.setOnClickListener {
            updateText(buttonD.text.toString(), dialogTextField)
        }
        buttonE.setOnClickListener {
            updateText(buttonE.text.toString(), dialogTextField)
        }
        buttonF.setOnClickListener {
            updateText(buttonF.text.toString(), dialogTextField)
        }
        buttonG.setOnClickListener {
            updateText(buttonG.text.toString(), dialogTextField)
        }
        buttonH.setOnClickListener {
            updateText(buttonH.text.toString(), dialogTextField)
        }
        buttonI.setOnClickListener {
            updateText(buttonI.text.toString(), dialogTextField)
        }
        buttonJ.setOnClickListener {
            updateText(buttonJ.text.toString(), dialogTextField)
        }
        buttonK.setOnClickListener {
            updateText(buttonK.text.toString(), dialogTextField)
        }
        buttonL.setOnClickListener {
            updateText(buttonL.text.toString(), dialogTextField)
        }
        buttonM.setOnClickListener {
            updateText(buttonM.text.toString(), dialogTextField)
        }
        buttonN.setOnClickListener {
            updateText(buttonN.text.toString(), dialogTextField)
        }
        buttonO.setOnClickListener {
            updateText(buttonO.text.toString(), dialogTextField)
        }
        buttonP.setOnClickListener {
            updateText(buttonP.text.toString(), dialogTextField)
        }
        buttonQ.setOnClickListener {
            updateText(buttonQ.text.toString(), dialogTextField)
        }
        buttonR.setOnClickListener {
            updateText(buttonR.text.toString(), dialogTextField)
        }
        buttonS.setOnClickListener {
            updateText(buttonS.text.toString(), dialogTextField)
        }
        buttonT.setOnClickListener {
            updateText(buttonT.text.toString(), dialogTextField)
        }
        buttonU.setOnClickListener {
            updateText(buttonU.text.toString(), dialogTextField)
        }
        buttonV.setOnClickListener {
            updateText(buttonV.text.toString(), dialogTextField)
        }
        buttonX.setOnClickListener {
            updateText(buttonX.text.toString(), dialogTextField)
        }
        buttonW.setOnClickListener {
            updateText(buttonW.text.toString(), dialogTextField)
        }
        buttonY.setOnClickListener {
            updateText(buttonY.text.toString(), dialogTextField)
        }
        buttonZ.setOnClickListener {
            updateText(buttonZ.text.toString(), dialogTextField)
        }
    }

    private fun ActivityMainBinding.setNumericButton() {
        button0.setOnClickListener {
            updateText(getString(R.string.n0), dialogTextField)
        }
        button1.setOnClickListener {
            updateText(getString(R.string.n1), dialogTextField)
        }
        button2.setOnClickListener {
            updateText(getString(R.string.n2), dialogTextField)
        }
        button3.setOnClickListener {
            updateText(getString(R.string.n3), dialogTextField)
        }
        button4.setOnClickListener {
            updateText(getString(R.string.n4), dialogTextField)
        }
        button5.setOnClickListener {
            updateText(getString(R.string.n5), dialogTextField)
        }
        button6.setOnClickListener {
            updateText(getString(R.string.n6), dialogTextField)
        }
        button7.setOnClickListener {
            updateText(getString(R.string.n7), dialogTextField)
        }
        button8.setOnClickListener {
            updateText(getString(R.string.n8), dialogTextField)
        }
        button9.setOnClickListener {
            updateText(getString(R.string.n9), dialogTextField)
        }
    }

}