const DateTime = luxon.DateTime;

let dateEditor = function (cell, onRendered, success, cancel) {
    let cellValue = luxon.DateTime.fromFormat(cell.getValue(), "yyyy-MM-dd").toFormat("yyyy-MM-dd"),
        input = document.createElement("input");

    input.setAttribute("type", "date");

    input.style.padding = "4px";
    input.style.width = "100%";
    input.style.boxSizing = "border-box";

    input.value = cellValue;

    onRendered(function () {
        input.focus();
        input.style.height = "100%";
    });

    function onChange() {
        if (input.value !== cellValue) {
            success(luxon.DateTime.fromFormat(input.value, "yyyy-MM-dd").toFormat("yyyy-MM-dd"));
        } else {
            cancel();
        }
    }

    input.addEventListener("blur", onChange);

    input.addEventListener("keydown", function (e) {
        if (KeyboardEvent.code === 13) {
            onChange();
        }
        if (KeyboardEvent.code === 27) {
            cancel();
        }
    });

    return input;
}

let dateMutator = function (value, data, type, params, component) {
    // 값이 없으면 현재 날짜로 설정
    if (value === undefined)
        value = DateTime.now().toISODate();

    let re = /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}$/
    if (re.exec(value))
        value = value.substring(0, 10);

    // yyyy-mm-dd 형식으로 들어온 값인지 확인
    re = /^\d{4}-\d{2}-\d{2}$/
    if (re.exec(value))
        return value;

    re = /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}$/
    if (re.exec(value))
        return value.substring(0, 10);

    // 객체로 들어온 값이면 문자열로 변환
    let date = value['date'];
    if (date['month'].toString().length === 1) {
        date['month'] = '0' + date['month'].toString();
    }
    if (date['day'].toString().length === 1) {
        date['day'] = '0' + date['day'].toString();
    }
    return date['year'] + '-' + date['month'] + '-' + date['day'];
}
