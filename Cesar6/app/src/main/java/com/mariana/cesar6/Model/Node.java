package com.mariana.cesar6.Model;


import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class Node implements Parcelable {
    private String email;
    private String body;
    private Node next;

    public Node(String email, String body) {
        this.email = email;
        this.body = body;
        this.next = null;
    }

    protected Node(Parcel in) {
        email = in.readString();
        body = in.readString();
        next = in.readParcelable(Node.class.getClassLoader());
    }

    public static final Creator<Node> CREATOR = new Creator<Node>() {
        @Override
        public Node createFromParcel(Parcel in) {
            return new Node(in);
        }

        @Override
        public Node[] newArray(int size) {
            return new Node[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(body);
        dest.writeParcelable(next, flags);
    }
}