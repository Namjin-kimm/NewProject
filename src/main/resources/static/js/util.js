function nullCheck(data, dest, dest2, kind){
    if(data = null || data == ""){
        dest.html(kind + " 필수입니다");
        dest2.html("");
        return false;
    }else{
        dest2.html("정상입니다");
        dest.html("");
        return true;
    }
}