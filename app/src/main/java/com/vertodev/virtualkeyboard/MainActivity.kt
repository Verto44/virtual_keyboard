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

        binding.displayTextField.showSoftInputOnFocus = false

        alphaNumericKeyboard()
        numericKeyboard()

        binding.textClear.setOnClickListener {
            binding.displayTextField.setText("")
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
                backspaceFunction(displayTextField)
            }
            buttonCaps.setOnClickListener {
                capsFunction()
            }

        }
    }

    private fun numericKeyboard() {
        with(binding) {
            numericButton0.setOnClickListener {
                updateText(getString(R.string.n0), displayTextField)
            }
            numericButton1.setOnClickListener {
                updateText(getString(R.string.n1), displayTextField)
            }
            numericButton2.setOnClickListener {
                updateText(getString(R.string.n2), displayTextField)
            }
            numericButton3.setOnClickListener {
                updateText(getString(R.string.n3), displayTextField)
            }
            numericButton4.setOnClickListener {
                updateText(getString(R.string.n4), displayTextField)
            }
            numericButton5.setOnClickListener {
                updateText(getString(R.string.n5), displayTextField)
            }
            numericButton6.setOnClickListener {
                updateText(getString(R.string.n6), displayTextField)
            }
            numericButton7.setOnClickListener {
                updateText(getString(R.string.n7), displayTextField)
            }
            numericButton8.setOnClickListener {
                updateText(getString(R.string.n8), displayTextField)
            }
            numericButton9.setOnClickListener {
                updateText(getString(R.string.n9), displayTextField)
            }
            numericButtonP.setOnClickListener {
                updateText(getString(R.string.s_ponto), displayTextField)
            }
            numericButtonDel.setOnClickListener {
                backspaceFunction(displayTextField)
            }
        }
    }

    private fun ActivityMainBinding.setSimbolsButton() {
        buttonArroba.setOnClickListener {
            updateText(buttonArroba.text.toString(), displayTextField)
        }
        buttonPonto.setOnClickListener {
            updateText(buttonPonto.text.toString(), displayTextField)
        }
        buttonPercent.setOnClickListener {
            updateText(buttonPercent.text.toString(), displayTextField)
        }
        buttonDoisPontos.setOnClickListener {
            updateText(buttonDoisPontos.text.toString(), displayTextField)
        }
        buttonTraco.setOnClickListener {
            updateText(buttonTraco.text.toString(), displayTextField)
        }
        buttonUnderline.setOnClickListener {
            updateText(buttonUnderline.text.toString(), displayTextField)
        }
        buttonEsclamacao.setOnClickListener {
            updateText(buttonEsclamacao.text.toString(), displayTextField)
        }
        buttonInterrogacao.setOnClickListener {
            updateText(buttonInterrogacao.text.toString(), displayTextField)
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
            updateText(buttonA.text.toString(), displayTextField)
        }
        buttonB.setOnClickListener {
            updateText(buttonB.text.toString(), displayTextField)
        }
        buttonC.setOnClickListener {
            updateText(buttonC.text.toString(), displayTextField)
        }
        buttonD.setOnClickListener {
            updateText(buttonD.text.toString(), displayTextField)
        }
        buttonE.setOnClickListener {
            updateText(buttonE.text.toString(), displayTextField)
        }
        buttonF.setOnClickListener {
            updateText(buttonF.text.toString(), displayTextField)
        }
        buttonG.setOnClickListener {
            updateText(buttonG.text.toString(), displayTextField)
        }
        buttonH.setOnClickListener {
            updateText(buttonH.text.toString(), displayTextField)
        }
        buttonI.setOnClickListener {
            updateText(buttonI.text.toString(), displayTextField)
        }
        buttonJ.setOnClickListener {
            updateText(buttonJ.text.toString(), displayTextField)
        }
        buttonK.setOnClickListener {
            updateText(buttonK.text.toString(), displayTextField)
        }
        buttonL.setOnClickListener {
            updateText(buttonL.text.toString(), displayTextField)
        }
        buttonM.setOnClickListener {
            updateText(buttonM.text.toString(), displayTextField)
        }
        buttonN.setOnClickListener {
            updateText(buttonN.text.toString(), displayTextField)
        }
        buttonO.setOnClickListener {
            updateText(buttonO.text.toString(), displayTextField)
        }
        buttonP.setOnClickListener {
            updateText(buttonP.text.toString(), displayTextField)
        }
        buttonQ.setOnClickListener {
            updateText(buttonQ.text.toString(), displayTextField)
        }
        buttonR.setOnClickListener {
            updateText(buttonR.text.toString(), displayTextField)
        }
        buttonS.setOnClickListener {
            updateText(buttonS.text.toString(), displayTextField)
        }
        buttonT.setOnClickListener {
            updateText(buttonT.text.toString(), displayTextField)
        }
        buttonU.setOnClickListener {
            updateText(buttonU.text.toString(), displayTextField)
        }
        buttonV.setOnClickListener {
            updateText(buttonV.text.toString(), displayTextField)
        }
        buttonX.setOnClickListener {
            updateText(buttonX.text.toString(), displayTextField)
        }
        buttonW.setOnClickListener {
            updateText(buttonW.text.toString(), displayTextField)
        }
        buttonY.setOnClickListener {
            updateText(buttonY.text.toString(), displayTextField)
        }
        buttonZ.setOnClickListener {
            updateText(buttonZ.text.toString(), displayTextField)
        }
    }

    private fun ActivityMainBinding.setNumericButton() {
        button0.setOnClickListener {
            updateText(getString(R.string.n0), displayTextField)
        }
        button1.setOnClickListener {
            updateText(getString(R.string.n1), displayTextField)
        }
        button2.setOnClickListener {
            updateText(getString(R.string.n2), displayTextField)
        }
        button3.setOnClickListener {
            updateText(getString(R.string.n3), displayTextField)
        }
        button4.setOnClickListener {
            updateText(getString(R.string.n4), displayTextField)
        }
        button5.setOnClickListener {
            updateText(getString(R.string.n5), displayTextField)
        }
        button6.setOnClickListener {
            updateText(getString(R.string.n6), displayTextField)
        }
        button7.setOnClickListener {
            updateText(getString(R.string.n7), displayTextField)
        }
        button8.setOnClickListener {
            updateText(getString(R.string.n8), displayTextField)
        }
        button9.setOnClickListener {
            updateText(getString(R.string.n9), displayTextField)
        }
    }

}