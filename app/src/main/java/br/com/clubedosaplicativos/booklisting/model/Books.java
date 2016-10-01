package br.com.clubedosaplicativos.booklisting.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by elifa on 27/09/2016.
 */
public class Books implements Parcelable {
    private String kind;
    private String id;
    private VolumeInfoBean volumeInfo;

    public Books(String kind, String id, VolumeInfoBean volumeInfo) {
        this.kind = kind;
        this.id = id;
        this.volumeInfo = volumeInfo;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolumeInfoBean getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfoBean volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public static class VolumeInfoBean implements Parcelable {
        private String title;
        private String subTitle;
        private String description;
        private String infoLink;
        private List<String> authors;

        public VolumeInfoBean(String title, String subTitle, String description, String infoLink, List<String> authors) {
            this.title = title;
            this.subTitle = subTitle;
            this.description = description;
            this.infoLink = infoLink;
            this.authors = authors;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getInfoLink() {
            return infoLink;
        }

        public void setInfoLink(String infoLink) {
            this.infoLink = infoLink;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.title);
            dest.writeString(this.subTitle);
            dest.writeString(this.description);
            dest.writeString(this.infoLink);
            dest.writeStringList(this.authors);
        }

        protected VolumeInfoBean(Parcel in) {
            this.title = in.readString();
            this.subTitle = in.readString();
            this.description = in.readString();
            this.infoLink = in.readString();
            this.authors = in.createStringArrayList();
        }

        public static final Creator<VolumeInfoBean> CREATOR = new Creator<VolumeInfoBean>() {
            @Override
            public VolumeInfoBean createFromParcel(Parcel source) {
                return new VolumeInfoBean(source);
            }

            @Override
            public VolumeInfoBean[] newArray(int size) {
                return new VolumeInfoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.kind);
        dest.writeString(this.id);
        dest.writeParcelable(this.volumeInfo, flags);
    }

    protected Books(Parcel in) {
        this.kind = in.readString();
        this.id = in.readString();
        this.volumeInfo = in.readParcelable(VolumeInfoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Books> CREATOR = new Parcelable.Creator<Books>() {
        @Override
        public Books createFromParcel(Parcel source) {
            return new Books(source);
        }

        @Override
        public Books[] newArray(int size) {
            return new Books[size];
        }
    };
}
