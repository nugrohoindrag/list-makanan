package picodiploma.dicoding.warungbekasi.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Hidangan implements Parcelable {
    private String name, from, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.from);
        dest.writeString(this.photo);
    }

    Hidangan() {
    }

    private Hidangan(Parcel in) {
        this.name = in.readString();
        this.from = in.readString();
        this.photo = in.readString();
    }

    public static final Creator<Hidangan> CREATOR = new Creator<Hidangan>() {
        @Override
        public Hidangan createFromParcel(Parcel source) {
            return new Hidangan(source);
        }

        @Override
        public Hidangan[] newArray(int size) {
            return new Hidangan[size];
        }
    };
}
