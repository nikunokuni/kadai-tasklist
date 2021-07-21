package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Task;

public class TaskValidator {
//今回はチェック項目が一つだけなので戻り値はString型にしてもよい
    public static List<String> validate(Task t){
        List<String> errors = new ArrayList<String>();
        String content_error=validateContent(t.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }
        return errors;
    }


private static String validateContent(String content) {
    if(content == null||content.equals("")) {
        return "タスク内容を入力してね";
    }
    return "";
}
}