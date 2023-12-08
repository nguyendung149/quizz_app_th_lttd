package com.example.myquizzapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String ="total_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1,
            "Phía nam của châu Mỹ Latinh, giữa Chile và Uruguay. Có biên giới với Chile về phía tây, Uruguay về phía đông, Paraguay và Bolivia về phía bắc, Brazil về phía đông bắc, và Đại Tây Dương về phía đông"
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3,
            "Một quốc gia lớn và đa dạng về địa lý, chiếm một lục địa cả về độ lớn và diện tích. Nó nằm ở phía nam của Đại Tây Dương và tách biệt với Đông Timor, Indonesia, và Papua New Guinea về phía bắc"
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4,
            "Nằm ở Nam Mỹ và chiếm phần lớn khu vực đông nam châu lục này. Có bờ biển dài trên Đại Tây Dương. Có dân số lớn thứ năm thế giới"
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2,
            "Nằm ở Tây Âu và giữa Hà Lan, Đức, Luxembourg, Pháp và Biển Bắc. Một quốc gia có nền kinh tế mạnh mẽ với các ngành công nghiệp đa dạng như sản xuất thép, hóa chất, và dịch vụ tài chính"
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3,
            "Một quốc gia đảo tại khu vực Oceania, nằm ở Thái Bình Dương Nam. Gồm một nhóm lớn các đảo, với khoảng 332 đảo lớn và nhỏ"
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1,
            "Nằm ở trung tâm châu Âu và giữ một vị trí quan trọng về mặt địa lý. Giáp các nước như Pháp, Bỉ, Hà Lan, Luxembourg, Thụy Sĩ, Áo, Cộng hòa Séc, Ba Lan, Đan Mạch, và biển Baltic và biển Bắc. Có dân số lớn và là quốc gia có dân số đông nhất trong Liên minh châu Âu (EU)"
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3,
            "Nằm ở bờ biển tây nam của Bắc Biển. Giáp Đức về phía nam và có liên kết với Thụy Điển bằng một cây cầu cảng lớn được biết đến là Cầu Öresund"
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4,
            "Nằm ở Nam Á và là quốc gia lớn thứ bảy trên thế giới về diện tích. Giáp Pakistan về phía tây, Trung Quốc và Nepal về phía bắc, Bhutan về phía đông bắc, và Bangladesh và Myanmar về phía đông. Có dân số đông đúc, là quốc gia dân số đông nhất thế giới sau Trung Quốc"
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2,
            "Một quốc gia đảo nằm ở Tây Nam Thái Bình Dương. Gồm hai đảo lớn chính là Bắc Đảo (North Island) và Nam Đảo (South Island), cũng như nhiều đảo nhỏ xung quanh."
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1,
            "Nằm ở trung tâm Tây Á, bên bờ biển phía đông của Vịnh Ba Tư. Giữa Iraq và Saudi Arabia"
        )

        questionsList.add(que10)


        return questionsList
    }
}