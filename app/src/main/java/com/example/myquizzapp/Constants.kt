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

        //11
        val que11 = Question(
            11, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_aicap,
            "Janpan", "Jordan",
            "Egypt", "Ghana", 3,
            "Nằm ở phía đông bắc châu Phi và có một phần ở Trung Đông, nằm giữa Biển Đỏ và Địa Trung Hải. Có một lịch sử lâu dài và là nơi nảy sinh nền văn minh cổ đại với những đền đài nổi tiếng như Pyramids of Giza và Sphinx"
        )
        questionsList.add(que11)

        //12
        val que12 = Question(
            12, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_algeria,
            "Ethiopia", "algeria",
            "Madagascar", "Somalia", 2,
            "Một quốc gia nằm ở phía bắc châu Phi. Có những di tích lịch sử và văn hóa quan trọng như thành phố cổ Timgad, thành phố địa đạo Constantine, và sa mạc Sahara"
        )
        questionsList.add(que12)

        //13
        val que13 = Question(
            13, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_angola,
            "Botswana", "Zimbabwe",
            "Sudan", "Angola", 4,
            "Một quốc gia nằm ở phía tây nam châu Phi. Có các điểm du lịch hấp dẫn như thác nước Kalandula, sa mạc Namib, và thành phố cổ M'banza-Kongo."
        )
        questionsList.add(que13)

        //14
        val que14 = Question(
            14, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_ivorycoast,
            "Morocco", "Australia",
            "Ivory Coast", "Egypt", 3,
            "Nằm ở Tây Phi và có bờ biển dài trên Đại Tây Dương về phía nam. Có nhiều bảo tàng ở Abidjan và các thành phố lớn khác, giữ cho di sản văn hóa và lịch sử của nước này. Di tích văn hóa và tự nhiên nổi tiếng bao gồm Công viên Tai và các khu bảo tồn tự nhiên khác."
        )
        questionsList.add(que14)

        //15
        val que15 = Question(
            15, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_portugal,
            "Portugal", "Netherlands",
            "Croatia", "Egypt", 1,
            "nằm ở Tây Nam châu Âu, trên bờ biển Tây Bắc của Bán đảo Iberia. Có một lịch sử lâu dài, với vai trò lớn trong Đại Tây Dương và thời kỳ khám phá. Văn hóa nước này được ảnh hưởng bởi các yếu tố La-tinh và có nền văn hóa phong phú."
        )
        questionsList.add(que15)

        //16
        val que16 = Question(
            16, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_brunei,
            "Spain", "Romania",
            "Ukraine", "Brunei", 4,
            "Nằm ở Đông Nam Á, trên đảo Borneo, giữa Malaysia và Biển Đông. Chịu ảnh hưởng lớn từ Hòa thượng Islam và các truyền thống văn hóa Melayu"
        )
        questionsList.add(que16)

        //17
        val que17 = Question(
            17, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_cambodia,
            "Algeria", "Cambodia",
            "Fiji", "Indonesia", 2,
            "Nằm ở trung tâm Đông Nam Á và có biên giới với Thái Lan, Lào, Việt Nam và Biển Đông. Hòa thượng Phật giáo là tôn giáo lớn nhất, chiếm đa số dân số"
        )
        questionsList.add(que17)

        //18
        val que18 = Question(
            18, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_croatia,
            "Sudan", "Slovenia",
            "Croatia", "Czech Republic", 3,
            "Nằm ở khu vực Đông Âu, trên bờ biển biển Adriatic, giữa Bosnia và Herzegovina, Slovenia, Hungary, Serbia, và Montenegro. Có một di sản văn hóa phong phú, với ảnh hưởng từ cả Đông và Tây Âu. Thành phố Dubrovnik, di tích thế giới UNESCO, và các đảo biển Adriatic là điểm du lịch nổi tiếng"
        )
        questionsList.add(que18)

        //19
        val que19 = Question(
            19, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_korea,
            "South Korea", "Paraguay",
            "Chile", "North Korea", 1,
            "Có một lịch sử văn hóa lâu dài với nghệ thuật truyền thống như Pansori và Hanbok (trang phục truyền thống). K-pop và phim K-drama đang ngày càng trở nên phổ biến trên toàn thế giới."
        )
        questionsList.add(que19)

        //20
        val que20 = Question(
            20, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_greece,
            "Switzerland", "Paraguay",
            "Cyprus", "Greece", 4,
            "Nằm ở Nam Âu, trên bờ biển Đông của Biển Địa Trung Hải. Có một lịch sử lâu dài và là quê hương của nền văn minh cổ đại, với các thành phố như Athens, Sparta, và Olympia."
        )
        questionsList.add(que20)

        //21
        val que21 = Question(
            21, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_norway,
            "Tanzania", "Democratic Republic of the Congo",
            "Norway", "Namibia", 3,
            "Nằm ở Bắc Âu, chiếm phần lớn của Bán đảo Scandinavia. Liên quan đến những thời kỳ như thời Viking và thời kỳ Trung cổ"
        )
        questionsList.add(que21)

        //22
        val que22 = Question(
            22, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_myanmar,
            "Libya", "Tunisia",
            "Myanmar", "Sudan", 3,
            "Có biên giới với nhiều quốc gia, bao gồm Bangladesh, Ấn Độ, Trung Quốc, Lào và Thái Lan. Phật giáo Theravada là tôn giáo chủ đạo"
        )
        questionsList.add(que22)

        //23
        val que23 = Question(
            23, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_spain,
            "United Kingdom", "spain",
            "Finland", "Latvia", 2,
            "Nằm ở miền nam châu Âu, trên bán đảo Iberia. Có các thành phố quan trọng: Barcelona, Valencia, Seville, Zaragoza, và nhiều thành phố khác"
        )
        questionsList.add(que23)

        //24
        val que24 = Question(
            24, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_thailand,
            "Philippines", "Malaysia",
            "Thailand", "Latvia", 3,
            "Có một lịch sử lâu dài với các triều đại như Ayutthaya và Sukhothai. Đất nước này không bao giờ bị chinh phục bởi các đế quốc châu Âu trong thời kỳ thực dân. Tôn Giáo phổ biến nhất: Phật giáo Theravada"
        )
        questionsList.add(que24)

        //25
        val que25 = Question(
            25, "Đây là cờ của nước nào?",
            R.drawable.ic_flag_of_vietnam,
            "Vietnam", "Malaysia",
            "Laos", "Singapore", 1,
            "Nằm ở trung tâm Đông Nam Á. Có một lịch sử và văn hóa đa dạng, với ảnh hưởng từ nền văn hóa Đông Á, chủ yếu là Trung Quốc. Có một lịch sử chiến tranh dài và đầy biến động, với những sự kiện quan trọng như Chiến tranh Việt Nam. điểm đến du lịch phổ biến với cảnh đẹp tự nhiên như vịnh Hạ Long, đồng bằng sông Cửu Long, và các di tích lịch sử như đền tháp Mỹ Sơn, cố đô Huế"
        )
        questionsList.add(que25)




        return questionsList
    }
}