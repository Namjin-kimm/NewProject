let results = [false, false, false, false, false, false, false]
let idResult = false;
let pwResult = false;
let pwCheckResult = false;
let nameResult = false;
let emailResult = false;
let ageResult = false;
let birthResult = false;


$("#id").blur(function(){
    let id = $("#id").val();
    idResult = nullCheck(id, "#idm", "#idm2", "ID");
    results[0] = idResult;
})

$("#pw").on({
    blur:function(){
        pwResult = nullCheck($("#pw").val(), "#pwm", "#pwm2", "PW" )
        results[1] = pwResult;
    },
    change:function(){
        $("#pwCheck").val("");
        results[2] = equals($("#pw").val(), $("#pwCheck").val(), "#pwCheckm", "#pwCheckm2");
    }
})

$("#pwCheck").on({
    blur:function(){
        pwCheckResult = equals($("#pw").val(), $("#pwCheck").val(), "#pwCheckm", "#pwCheckm2");
        results[2] = pwCheckResult;
    },
    change:function(){
        results[2] = equals($("#pwCheck").val(), $("#pw").val(), "#pwCheckm2", "#pwCheckm");
    }
})

$("#name").blur(function(){
    let name = $("#name").val();
    nameResult = nullCheck(name, "#namem", "#namem2", "NAME");
    results[3] = nameResult;
})

$("#email").blur(function(){
    let email = $("#email").val();
    emailResult = nullCheck(email, "#emailm", "#emailm2", "EMAIL");
    results[4] = nameResult;
})

$("#age").blur(function(){
    let age = $("#age").val();
    ageResult = nullCheck(age, "#agem", "#agem2", "AGE");
    results[5] = ageResult;
})

$("#birth").blur(function(){
    let birth = $("#birth").val();
    birthResult = nullCheck(birth, "#birthm", "#birthm2", "BIRTHDAY");
    results[6] = birthResult;
})
