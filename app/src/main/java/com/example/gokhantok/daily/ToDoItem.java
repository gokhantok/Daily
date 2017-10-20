package com.example.gokhantok.daily;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ToDoItem implements Serializable{
    private String mToDoText;
    private String mToDoContent;
    private String mPathImg;
    private boolean mHasReminder;
//    private Date mLastEdited;
    private int mTodoColor;
    private Date mToDoDate;
    private UUID mTodoIdentifier;
    private static final String TODOTEXT = "todotext";
    private static final String TODOBODY = "todocontent";
    private static final String TODOPATHIMG = "todopathImg";
    private static final String TODOREMINDER = "todoreminder";
//    private static final String TODOLASTEDITED = "todolastedited";
    private static final String TODOCOLOR = "todocolor";
    private static final String TODODATE = "tododate";
    private static final String TODOIDENTIFIER = "todoidentifier";


    public ToDoItem(String todoBody, String todoContent, String pathImg, boolean hasReminder, Date toDoDate){
        mToDoText = todoBody;
        mToDoContent = todoContent;
        mPathImg = pathImg;
        mHasReminder = hasReminder;
        mToDoDate = toDoDate;
        mTodoColor = 1677725;
        mTodoIdentifier = UUID.randomUUID();
    }

    public ToDoItem(JSONObject jsonObject) throws JSONException{
        mToDoText = jsonObject.getString(TODOTEXT);
        mToDoContent = jsonObject.getString(TODOBODY);
        mPathImg =jsonObject.getString(TODOPATHIMG);
        mHasReminder = jsonObject.getBoolean(TODOREMINDER);
        mTodoColor = jsonObject.getInt(TODOCOLOR);
        mTodoIdentifier = UUID.fromString(jsonObject.getString(TODOIDENTIFIER));

//        if(jsonObject.has(TODOLASTEDITED)){
//            mLastEdited = new Date(jsonObject.getLong(TODOLASTEDITED));
//        }
        if(jsonObject.has(TODODATE)){
            mToDoDate = new Date(jsonObject.getLong(TODODATE));
        }
    }

    public JSONObject toJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(TODOTEXT, mToDoText);
        jsonObject.put(TODOBODY, mToDoContent);
        jsonObject.put(TODOPATHIMG,mPathImg);
        jsonObject.put(TODOREMINDER, mHasReminder);
//        jsonObject.put(TODOLASTEDITED, mLastEdited.getTime());
        if(mToDoDate!=null){
            jsonObject.put(TODODATE, mToDoDate.getTime());
        }
        jsonObject.put(TODOCOLOR, mTodoColor);
        jsonObject.put(TODOIDENTIFIER, mTodoIdentifier.toString());

        return jsonObject;
    }


    public ToDoItem(){
        this("Clean my room", "içerik", "", true, new Date());
    }

    public String getToDoText() {
        return mToDoText;
    }

    public String getToDoContent() { return mToDoContent;}

    public String getPathImg() { return mPathImg;}

    public void setToDoText(String mToDoText) {
        this.mToDoText = mToDoText;
    }
    public void setToDoContent(String mToDoContent) {
        this.mToDoContent = mToDoContent;
    }

    public void setPathImg(String mPathImg) {
        this.mPathImg = mPathImg;
    }

    public boolean hasReminder() {
        return mHasReminder;
    }

    public void setHasReminder(boolean mHasReminder) {
        this.mHasReminder = mHasReminder;
    }

    public Date getToDoDate() {
        return mToDoDate;
    }

    public int getTodoColor() {
        return mTodoColor;
    }

    public void setTodoColor(int mTodoColor) {
        this.mTodoColor = mTodoColor;
    }

    public void setToDoDate(Date mToDoDate) {
        this.mToDoDate = mToDoDate;
    }


    public UUID getIdentifier(){
        return mTodoIdentifier;
    }
}

