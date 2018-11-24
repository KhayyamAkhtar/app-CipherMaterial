package kastigatordev.ciphermaterial

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Toast
import android.content.Context.CLIPBOARD_SERVICE



class CodingProcess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coding_process)
        //Setting android widgets to variables and constants START
        val initiateToButton = findViewById(R.id.initiate_button) as Button
        val shareResultButton = findViewById(R.id.share_result) as Button
        val messageShareButton = findViewById(R.id.message_share) as Button
        val messengerShareButton = findViewById(R.id.messenger_share) as Button
        var resultStringBack = findViewById(R.id.result_will_be_here) as TextView
        var forwardCheck = findViewById(R.id.forward_checkbox) as CheckBox
        var backwardCheck = findViewById(R.id.backward_checkbox) as CheckBox
        var alternateCheck = findViewById(R.id.alternate_checkbox) as CheckBox
        var encryptCheck = findViewById(R.id.encrypt_checkbox) as CheckBox
        var decryptCheck = findViewById(R.id.decrypt_checkbox) as CheckBox
        var userInString = findViewById(R.id.enter_text_here) as EditText
        var whatToDoKey = findViewById(R.id.enter_key) as EditText
        //Setting android widgets to variables and constants END

        //Checkboxes changing states so only one can be selected START
        forwardCheck.setOnClickListener {
            backwardCheck.isChecked = false
            alternateCheck.isChecked = false
        }
        backwardCheck.setOnClickListener {
            forwardCheck.isChecked = false
            alternateCheck.isChecked = false
        }
        alternateCheck.setOnClickListener {
            forwardCheck.isChecked = false
            backwardCheck.isChecked = false
        }
        encryptCheck.setOnClickListener {
            decryptCheck.isChecked = false
        }
        decryptCheck.setOnClickListener {
            encryptCheck.isChecked = false
        }
        //Checkboxes changing states so only one can be selected END

        //activity below on clicking initiate button START
        initiateToButton.setOnClickListener {
            val stringToEncode = userInString.getText().toString()
            val encodeKey = whatToDoKey.getText().toString() //Takes string from textfield
            var encodeKeyI = encodeKey.toInt() //Converts string to integer
            val stringToEncodeLength = stringToEncode.length //Takes string length
            var charCounter = 0
            var newString = ""
            var shiftChange = false

            var processProceed = true
            //Checks input field START
            if (stringToEncode == "") {
                //Toast Message START
                Toast.makeText(this, "Enter Text!", Toast.LENGTH_SHORT).show()
                //Toast Message END
                processProceed = false
            }
            //In Progress
            //if (encodeKeyI == null) {
            //    //Toast Message START
            //    Toast.makeText(this, "Enter Key!", Toast.LENGTH_SHORT).show()
                //Toast Message END
            //    processProceed = false
            //}
            //Checks input field END

            if (processProceed == true) {


                //Encrypt decrypt buttons results START
                //Encrypt options START
                if (encryptCheck.isChecked == true) {
                    //Forward button result START
                    if (forwardCheck.isChecked == true) {
                        while (charCounter != stringToEncodeLength) {
                            var CharCharacter = stringToEncode[charCounter]
                            var Alphi = CharCharacter.toInt()
                            var NewAlphi = Alphi + encodeKeyI
                            var NewChar = NewAlphi.toChar()
                            newString = newString + NewChar
                            charCounter = charCounter + 1
                        }
                        resultStringBack.setText(newString) //Outputs string
                        //Toast Message START
                        Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                        //Toast Message END
                    } else {
                        if (backwardCheck.isChecked == true) {
                            while (charCounter != stringToEncodeLength) {
                                var CharCharacter = stringToEncode[charCounter]
                                var Alphi = CharCharacter.toInt()
                                var NewAlphi = Alphi - encodeKeyI
                                var NewChar = NewAlphi.toChar()
                                newString = newString + NewChar
                                charCounter = charCounter + 1
                            }
                            resultStringBack.setText(newString) //Outputs string
                            //Toast Message START
                            Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                            //Toast Message END
                        } else {
                            if (alternateCheck.isChecked == true) {
                                while (charCounter != stringToEncodeLength) {
                                    if (shiftChange == false) {
                                        var CharCharacter = stringToEncode[charCounter]
                                        var Alphi = CharCharacter.toInt()
                                        var NewAlphi = Alphi - encodeKeyI
                                        var NewChar = NewAlphi.toChar()
                                        newString = newString + NewChar
                                        charCounter = charCounter + 1
                                        shiftChange = true
                                    } else {
                                        var CharCharacter = stringToEncode[charCounter]
                                        var Alphi = CharCharacter.toInt()
                                        var NewAlphi = Alphi + encodeKeyI
                                        var NewChar = NewAlphi.toChar()
                                        newString = newString + NewChar
                                        charCounter = charCounter + 1
                                        shiftChange = false
                                    }

                                }
                                resultStringBack.setText(newString) //Outputs string
                                //Toast Message START
                                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                                //Toast Message END
                            } else {
                                Toast.makeText(this, "Select one of the methods!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
                if (decryptCheck.isChecked == true) {
                    if (forwardCheck.isChecked == true) { //Forward method process START
                        while (charCounter != stringToEncodeLength) {
                            var CharCharacter = stringToEncode[charCounter]
                            var Alphi = CharCharacter.toInt()
                            var NewAlphi = Alphi - encodeKeyI
                            var NewChar = NewAlphi.toChar()
                            newString = newString + NewChar
                            charCounter = charCounter + 1
                        }
                        resultStringBack.setText(newString) //Outputs string
                        //Toast Message START
                        Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                        //Toast Message END
                    } else { //Forward method process END
                        if (backwardCheck.isChecked == true) { //Backward method process START
                            while (charCounter != stringToEncodeLength) {
                                var CharCharacter = stringToEncode[charCounter]
                                var Alphi = CharCharacter.toInt()
                                var NewAlphi = Alphi + encodeKeyI
                                var NewChar = NewAlphi.toChar()
                                newString = newString + NewChar
                                charCounter = charCounter + 1
                            }
                            resultStringBack.setText(newString) //Outputs string
                            //Toast Message START
                            Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                            //Toast Message END
                        } else { //Backward method process END
                            if (alternateCheck.isChecked == true) { //Alternate method process START
                                while (charCounter != stringToEncodeLength) {
                                    if (shiftChange == true) {
                                        var CharCharacter = stringToEncode[charCounter]
                                        var Alphi = CharCharacter.toInt()
                                        var NewAlphi = Alphi - encodeKeyI
                                        var NewChar = NewAlphi.toChar()
                                        newString = newString + NewChar
                                        charCounter = charCounter + 1
                                        shiftChange = false
                                    } else {
                                        var CharCharacter = stringToEncode[charCounter]
                                        var Alphi = CharCharacter.toInt()
                                        var NewAlphi = Alphi + encodeKeyI
                                        var NewChar = NewAlphi.toChar()
                                        newString = newString + NewChar
                                        charCounter = charCounter + 1
                                        shiftChange = true
                                    }

                                }
                                resultStringBack.setText(newString) //Outputs string
                                //Toast Message START
                                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                                //Toast Message END
                            } else { //Alternate method process END
                                Toast.makeText(this, "Select one of the methods!", Toast.LENGTH_SHORT).show() //Error output
                            }
                        }
                    }
                }
                if (encryptCheck.isChecked == false) {
                    if (decryptCheck.isChecked == false) {
                        Toast.makeText(this, "Select one of the process!", Toast.LENGTH_SHORT).show() //Error output
                    }
                }


                //activity on clicking share result button Whatsapp START
                shareResultButton.setOnClickListener {
                    //
                    var shareResultString = ""
                    if (forwardCheck.isChecked == true) {
                        shareResultString = newString + "\n" + "->K- " + encodeKey + "F"
                    } else {
                        if (backwardCheck.isChecked == true) {
                            shareResultString = newString + "\n" + "->K- " + encodeKey + "B"
                        } else {
                            if (alternateCheck.isChecked == true) {
                                shareResultString = newString + "\n" + "->K- " + encodeKey + "A"
                            }
                        }
                    }
                    val whatsappIntent = Intent(Intent.ACTION_SEND)
                    whatsappIntent.setType("text/plain")
                    whatsappIntent.setPackage("com.whatsapp")
                    whatsappIntent.putExtra(Intent.EXTRA_TEXT, shareResultString)
                    try {
                        startActivity(whatsappIntent)
                    } catch (ex: android.content.ActivityNotFoundException) {
                        Toast.makeText(this, "Whatsapp is not installed.", Toast.LENGTH_SHORT).show()
                    }
                }
                //activity on clicking share result button Whatsapp END

                //activity on clicking share result button Message START
                messageShareButton.setOnClickListener {
                    //
                    var shareResultString = ""
                    if (forwardCheck.isChecked == true) {
                        shareResultString = newString + "\n" + "->K- " + encodeKey + "F"
                    } else {
                        if (backwardCheck.isChecked == true) {
                            shareResultString = newString + "\n" + "->K- " + encodeKey + "B"
                        } else {
                            if (alternateCheck.isChecked == true) {
                                shareResultString = newString + "\n" + "->K- " + encodeKey + "A"
                            }
                        }
                    }

                    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as android.text.ClipboardManager
                    clipboard.text = shareResultString
                    Toast.makeText(applicationContext, "Text Copied to Clipboard", Toast.LENGTH_SHORT).show()

                    /*val MessageIntent = Intent(Intent.ACTION_SEND)
                    MessageIntent.setType("text/plain")
                    MessageIntent.setPackage("com.android.mms")
                    MessageIntent.putExtra(Intent.EXTRA_TEXT, shareResultString)
                    try {
                        startActivity(MessageIntent)
                    } catch (ex: android.content.ActivityNotFoundException) {
                        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
                    }*/
                }
                //activity on clicking share result button Message END

                //activity on clicking share result button Messenger START
                messengerShareButton.setOnClickListener {
                    //
                    var shareResultString = ""
                    if (forwardCheck.isChecked == true) {
                        shareResultString = newString + "\n" + "->K- " + encodeKey + "F"
                    } else {
                        if (backwardCheck.isChecked == true) {
                            shareResultString = newString + "\n" + "->K- " + encodeKey + "B"
                        } else {
                            if (alternateCheck.isChecked == true) {
                                shareResultString = newString + "\n" + "->K- " + encodeKey + "A"
                            }
                        }
                    }
                    val MessengerIntent = Intent(Intent.ACTION_SEND)
                    MessengerIntent.setType("text/plain")
                    MessengerIntent.setPackage("com.facebook.orca")
                    MessengerIntent.putExtra(Intent.EXTRA_TEXT, shareResultString)
                    try {
                        startActivity(MessengerIntent)
                    } catch (ex: android.content.ActivityNotFoundException) {
                        Toast.makeText(this, "Messenger is not installed.", Toast.LENGTH_SHORT).show()
                    }
                }
                //activity on clicking share result button Messenger END
            }
            //activity on clicking initiate button END
        }
    }
}

