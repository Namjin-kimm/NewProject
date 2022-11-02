let count = 0;

$("#fileAdd").click(function(){
    if(count < 5){
        $("#fileList").append($("#fileAddForm").html());
        count++;
    }else{
        alert("파일추가는 최대 5개까지 가능합니다");
    }
})

$("#fileList").on("click", ".del", function(){
    $(this).parent().remove();
    count--;
})

results = [false, false, false];
let writerResult = false;
let titleResult = false;
let contentsResult = false;

$("#writer").blur(function(){
    let writer = $("#writer").val();
    writerResult = nullCheck(writer, $("#writerm"), $("#writerm2"), "작성자");
    results[0] = writerResult;
})

$("#title").blur(function(){
    let title = $("#title").val();
    titleResult = nullCheck(title, $("#titlem"), $("#titlem2"), "제목");
    results[1] = titleResult;
})

$(".note-editable").blur(function(){
    let contents = $(".note-editable").text();
    console.log(contents = null || contents == "");
    contentsResult = nullCheck(contents, $("#contentsm"), $("#contentsm2"), "내용");
    results[2] = contentsResult;
})

$("#submitBtn").click(function(){
    if(results.includes("false")){
        alert("입력 조건을 지켜주세요");
    }else{
        alert("전송");
        $("#form").submit();
    }
})

