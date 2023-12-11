package com.example.myquizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class QuizzQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var mUserName: String? = null
    private var mCorrectAnswer: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null
    private var btnViewRank: Button? = null

    private var imgButtonHelp1: ImageButton? = null
    private var imgButtonHelp2: ImageButton? = null
    private var imgButtonHelp3: ImageButton? = null
    private var helpUsedCount1: Int = 0
    private val maxHelpCount1: Int = 1 // Số lần trợ giúp tối đa cho phép
    private var helpUsedCount2: Int = 0
    private val maxHelpCount2: Int = 1
    private var helpUsedCount3: Int = 0
    private val maxHelpCount3: Int = 1
    private var textCount1: TextView? = null
    private var textCount2: TextView? = null
    private var textCount3: TextView? = null
    private var hiddenIncorrectAnswer: Int = 0

    private var count: TextView? = null

    private var questionTimer: CountDownTimer? = null
    private val questionTimeInMillis: Long =
        10000 // Replace 10000 with the desired time in milliseconds
    private var isAnswered: Boolean = false
    private var flag_option = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_question)


        mUserName = intent.getStringExtra(Constants.USER_NAME)

        count = findViewById(R.id.countTime)

        progressBar = findViewById(R.id.progressBar)
        tvProgressBar = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvImage = findViewById(R.id.tv_image)

        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)



        imgButtonHelp1 = findViewById(R.id.optionHelp1)
        imgButtonHelp2 = findViewById(R.id.optionHelp2)
        imgButtonHelp3 = findViewById(R.id.optionHelp3)

        textCount1 = findViewById(R.id.count1)
        textCount2 = findViewById(R.id.count2)
        textCount3 = findViewById(R.id.count3)




        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        textCount1?.text = maxHelpCount1.toString()
        textCount2?.text = maxHelpCount2.toString()
        textCount3?.text = maxHelpCount3.toString()

        imgButtonHelp1?.setOnClickListener {
            if (helpUsedCount1 < maxHelpCount1) {
                showCorrectAnswer()
                helpUsedCount1++ // Nếu đã sử dụng hết lượt trợ giúp, có thể hiển thị thông báo tại đây
                updateHelpCountText1(maxHelpCount1, textCount1!!)
            } else {
                // Hiển thị thông báo khi đã sử dụng hết lượt trợ giúp
                Toast.makeText(
                    applicationContext,
                    "Bạn đã sử dụng hết lượt trợ giúp",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        imgButtonHelp2?.setOnClickListener {
            if (helpUsedCount2 < maxHelpCount2) {
                // Ẩn một đáp án sai
                hiddenIncorrectAnswer = hideOneIncorrectAnswer()


                helpUsedCount2++
                updateHelpCountText2(maxHelpCount2, textCount2!!)
            } else {
                // Hiển thị thông báo khi đã sử dụng hết lượt trợ giúp
                Toast.makeText(
                    applicationContext,
                    "Bạn đã sử dụng hết lượt trợ giúp",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        imgButtonHelp3?.setOnClickListener {
            if (helpUsedCount3 < maxHelpCount3) {
                // Kiểm tra xem câu hỏi có thông tin bổ sung không
                val currentQuestion: Question = mQuestionList!![mCurrentPosition - 1]
                if (!currentQuestion.additionalInfo.isNullOrBlank()) {
                    // Hiển thị thông tin câu hỏi
                    showQuestionInfo()
                    helpUsedCount3++
                    updateHelpCountText3(maxHelpCount3, textCount3!!)
                } else {
                    // Hiển thị thông báo khi không có thông tin bổ sung
                    Toast.makeText(
                        applicationContext,
                        "Câu hỏi này không có thông tin bổ sung",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                // Hiển thị thông báo khi đã sử dụng hết lượt trợ giúp
                Toast.makeText(
                    applicationContext,
                    "Bạn đã sử dụng hết lượt trợ giúp",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
        mQuestionList = Constants.getQuestions()
        setQuestion()


    }


    private fun setQuestion() {
        defaultOptionView()
        restoreAnswerOptions()
        val question: Question = mQuestionList!![mCurrentPosition - 1]

        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "SUBMIT"
        }
        startQuestionTimer()
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }


    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.tv_option_one -> {
                if (flag_option > 0) {
                    tvOptionOne?.let {
                        selectedOptionView(it, 1)
                        flag_option -= 1;
                    }
                }
            }

            R.id.tv_option_two -> {
                if (flag_option > 0) {
                    tvOptionTwo?.let {
                        selectedOptionView(it, 2)
                        flag_option-=1
                    }
                }
            }

            R.id.tv_option_three -> {
                if(flag_option>0) {
                    tvOptionThree?.let {
                        selectedOptionView(it, 3)
                        flag_option-=1
                    }
                }
            }

            R.id.tv_option_four -> {
                if (flag_option>0) {
                    tvOptionFour?.let {
                        selectedOptionView(it, 4)
                        flag_option-=1
                    }
                }
            }

            R.id.btn_submit -> {
                //TODO: "implement btn submit"

                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    flag_option = 1

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()

                        }

                        else -> {
                            val intent: Intent =
                                Intent(this@QuizzQuestionActivity, ResultActivity::class.java)

                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question: Question = mQuestionList!!.get(mCurrentPosition - 1)
                    if (question.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                    stopQuestionTimer()

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit?.text = "FINISH"
                    } else {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawable
                )
            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawable
                )
            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawable
                )
            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawable
                )
            }
        }
    }

    private fun showCorrectAnswer() {
        val currentQuestion: Question = mQuestionList!![mCurrentPosition - 1]

        // Hiển thị câu trả lời đúng
        answerView(currentQuestion.correctAnswer, R.drawable.correct_option_border_bg)
    }

    private fun updateHelpCountText1(maxHelpCount1: Int, textView: TextView) {
        val remainingHelps = maxHelpCount1 - helpUsedCount1
        textView.text = "$remainingHelps"
    }

    private fun updateHelpCountText2(maxHelpCount2: Int, textView: TextView) {
        val remainingHelps = maxHelpCount2 - helpUsedCount2
        textView.text = "$remainingHelps"
    }

    private fun updateHelpCountText3(maxHelpCount3: Int, textView: TextView) {
        val remainingHelps = maxHelpCount3 - helpUsedCount3
        textView.text = "$remainingHelps"
    }


    private fun hideOneIncorrectAnswer(): Int {
        val currentQuestion: Question = mQuestionList!![mCurrentPosition - 1]
        val correctAnswer = currentQuestion.correctAnswer

        // Chọn ngẫu nhiên một đáp án sai
        var incorrectAnswer: Int
        do {
            incorrectAnswer = (1..4).random()
        } while (incorrectAnswer == correctAnswer)

        // Ẩn đáp án sai
        hideIncorrectAnswer(incorrectAnswer)

        return incorrectAnswer
    }

    private fun hideIncorrectAnswer(answerNumber: Int) {
        when (answerNumber) {
            1 -> tvOptionOne?.visibility = View.GONE
            2 -> tvOptionTwo?.visibility = View.GONE
            3 -> tvOptionThree?.visibility = View.GONE
            4 -> tvOptionFour?.visibility = View.GONE
        }
    }

    // Hàm khôi phục tất cả các đáp án
    private fun restoreAnswerOptions() {
        tvOptionOne?.visibility = View.VISIBLE
        tvOptionTwo?.visibility = View.VISIBLE
        tvOptionThree?.visibility = View.VISIBLE
        tvOptionFour?.visibility = View.VISIBLE
    }

    private fun showQuestionInfo() {
        val currentQuestion: Question = mQuestionList!![mCurrentPosition - 1]
        val infoMessage = """
        |${currentQuestion.additionalInfo}
        |""".trimMargin()

        // Log để kiểm tra giá trị của infoMessage
        Log.d("InfoMessage", infoMessage)

        // Hiển thị thông tin trong AlertDialog
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Thông tin câu hỏi")
        alertDialogBuilder.setMessage(infoMessage)
        alertDialogBuilder.setPositiveButton("Đóng", null)

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun startQuestionTimer() {
        questionTimer?.cancel() // Hủy bỏ đếm ngược trước đó (nếu có)
        questionTimer = object : CountDownTimer(questionTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                count?.text = "Thời gian còn lại: $secondsRemaining giây"
            }

            override fun onFinish() {
                // Thời gian đếm ngược kết thúc, xử lý tùy thuộc vào logic của bạn
                submitQuestion()
            }
        }.start()
    }

    private fun submitQuestion() {
        mCurrentPosition++
        mSelectedOptionPosition = 0 // Reset the selected option position
        isAnswered = false // Reset the isAnswered flag

        when {
            mCurrentPosition <= mQuestionList!!.size -> {
                setQuestion()
                restartQuestionTimer() // Restart the countdown timer
            }

            else -> {
                // If no more questions, move to the ResultActivity
                stopQuestionTimer() // Stop the countdown timer
//                mCurrentPosition = 1
//                val intent: Intent = Intent(this@QuizzQuestionActivity, ResultActivity::class.java)
//                intent.putExtra(Constants.USER_NAME, mUserName)
//                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
//                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
//                startActivity(intent)
//                finish()

            }
        }
    }

    private fun restartQuestionTimer() {
        if (questionTimer != null) {
            questionTimer?.cancel()
        } // Hủy bỏ đồng hồ đếm ngược trước đó (nếu có)
        questionTimer = null
        startQuestionTimer()
    }

    private fun stopQuestionTimer() {
        if (questionTimer != null) {
            questionTimer?.cancel()

        }
        questionTimer = null
    }


}
