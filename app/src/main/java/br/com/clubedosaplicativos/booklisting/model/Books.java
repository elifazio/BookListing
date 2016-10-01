package br.com.clubedosaplicativos.booklisting.model;

import java.util.List;

/**
 * Created by elifa on 27/09/2016.
 */
public class Books {
    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private VolumeInfoBean volumeInfo;
    private SaleInfoBean saleInfo;
    private AccessInfoBean accessInfo;
    private SearchInfoBean searchInfo;

    public Books(String kind, String id, String etag, String selfLink, VolumeInfoBean volumeInfo, SaleInfoBean saleInfo, AccessInfoBean accessInfo, SearchInfoBean searchInfo) {
        this.kind = kind;
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
        this.saleInfo = saleInfo;
        this.accessInfo = accessInfo;
        this.searchInfo = searchInfo;
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

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public VolumeInfoBean getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfoBean volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public SaleInfoBean getSaleInfo() {
        return saleInfo;
    }

    public void setSaleInfo(SaleInfoBean saleInfo) {
        this.saleInfo = saleInfo;
    }

    public AccessInfoBean getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfoBean accessInfo) {
        this.accessInfo = accessInfo;
    }

    public SearchInfoBean getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(SearchInfoBean searchInfo) {
        this.searchInfo = searchInfo;
    }

    public static class VolumeInfoBean {
        private String title;
        private String subTitle;
        private String publisher;
        private String description;
        private ReadingModesBean readingModes;
        private int pageCount;
        private String printType;
        private double averageRating;
        private int ratingsCount;
        private String maturityRating;
        private boolean allowAnonLogging;
        private String contentVersion;
        private ImageLinksBean imageLinks;
        private String language;
        private String previewLink;
        private String infoLink;
        private String canonicalVolumeLink;
        private List<String> authors;
        private List<IndustryIdentifiersBean> industryIdentifiers;

        public VolumeInfoBean(String title, String subTitle, String publisher, String description, ReadingModesBean readingModes, int pageCount, String printType, double averageRating, int ratingsCount, String maturityRating, boolean allowAnonLogging, String contentVersion, ImageLinksBean imageLinks, String language, String previewLink, String infoLink, String canonicalVolumeLink, List<String> authors, List<IndustryIdentifiersBean> industryIdentifiers) {
            this.title = title;
            this.subTitle = subTitle;
            this.publisher = publisher;
            this.description = description;
            this.readingModes = readingModes;
            this.pageCount = pageCount;
            this.printType = printType;
            this.averageRating = averageRating;
            this.ratingsCount = ratingsCount;
            this.maturityRating = maturityRating;
            this.allowAnonLogging = allowAnonLogging;
            this.contentVersion = contentVersion;
            this.imageLinks = imageLinks;
            this.language = language;
            this.previewLink = previewLink;
            this.infoLink = infoLink;
            this.canonicalVolumeLink = canonicalVolumeLink;
            this.authors = authors;
            this.industryIdentifiers = industryIdentifiers;
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

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ReadingModesBean getReadingModes() {
            return readingModes;
        }

        public void setReadingModes(ReadingModesBean readingModes) {
            this.readingModes = readingModes;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public String getPrintType() {
            return printType;
        }

        public void setPrintType(String printType) {
            this.printType = printType;
        }

        public double getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(double averageRating) {
            this.averageRating = averageRating;
        }

        public int getRatingsCount() {
            return ratingsCount;
        }

        public void setRatingsCount(int ratingsCount) {
            this.ratingsCount = ratingsCount;
        }

        public String getMaturityRating() {
            return maturityRating;
        }

        public void setMaturityRating(String maturityRating) {
            this.maturityRating = maturityRating;
        }

        public boolean isAllowAnonLogging() {
            return allowAnonLogging;
        }

        public void setAllowAnonLogging(boolean allowAnonLogging) {
            this.allowAnonLogging = allowAnonLogging;
        }

        public String getContentVersion() {
            return contentVersion;
        }

        public void setContentVersion(String contentVersion) {
            this.contentVersion = contentVersion;
        }

        public ImageLinksBean getImageLinks() {
            return imageLinks;
        }

        public void setImageLinks(ImageLinksBean imageLinks) {
            this.imageLinks = imageLinks;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getPreviewLink() {
            return previewLink;
        }

        public void setPreviewLink(String previewLink) {
            this.previewLink = previewLink;
        }

        public String getInfoLink() {
            return infoLink;
        }

        public void setInfoLink(String infoLink) {
            this.infoLink = infoLink;
        }

        public String getCanonicalVolumeLink() {
            return canonicalVolumeLink;
        }

        public void setCanonicalVolumeLink(String canonicalVolumeLink) {
            this.canonicalVolumeLink = canonicalVolumeLink;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        public List<IndustryIdentifiersBean> getIndustryIdentifiers() {
            return industryIdentifiers;
        }

        public void setIndustryIdentifiers(List<IndustryIdentifiersBean> industryIdentifiers) {
            this.industryIdentifiers = industryIdentifiers;
        }

        public static class ReadingModesBean {
            private boolean text;
            private boolean image;

            public ReadingModesBean(boolean text, boolean image) {
                this.text = text;
                this.image = image;
            }

            public boolean isText() {
                return text;
            }

            public void setText(boolean text) {
                this.text = text;
            }

            public boolean isImage() {
                return image;
            }

            public void setImage(boolean image) {
                this.image = image;
            }
        }

        public static class ImageLinksBean {
            private String smallThumbnail;
            private String thumbnail;

            public ImageLinksBean(String smallThumbnail, String thumbnail) {
                this.smallThumbnail = smallThumbnail;
                this.thumbnail = thumbnail;
            }

            public String getSmallThumbnail() {
                return smallThumbnail;
            }

            public void setSmallThumbnail(String smallThumbnail) {
                this.smallThumbnail = smallThumbnail;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
        }

        public static class IndustryIdentifiersBean {
            private String type;
            private String identifier;

            public IndustryIdentifiersBean(String type, String identifier) {
                this.type = type;
                this.identifier = identifier;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getIdentifier() {
                return identifier;
            }

            public void setIdentifier(String identifier) {
                this.identifier = identifier;
            }
        }
    }

    public static class SaleInfoBean {
        private String country;
        private String saleability;
        private boolean isEbook;

        public SaleInfoBean(String country, String saleability, boolean isEbook) {
            this.country = country;
            this.saleability = saleability;
            this.isEbook = isEbook;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getSaleability() {
            return saleability;
        }

        public void setSaleability(String saleability) {
            this.saleability = saleability;
        }

        public boolean isIsEbook() {
            return isEbook;
        }

        public void setIsEbook(boolean isEbook) {
            this.isEbook = isEbook;
        }
    }

    public static class AccessInfoBean {
        private String country;
        private String viewability;
        private boolean embeddable;
        private boolean publicDomain;
        private String textToSpeechPermission;
        private EpubBean epub;
        private PdfBean pdf;
        private String webReaderLink;
        private String accessViewStatus;
        private boolean quoteSharingAllowed;

        public AccessInfoBean(String country, String viewability, boolean embeddable, boolean publicDomain, String textToSpeechPermission, EpubBean epub, PdfBean pdf, String webReaderLink, String accessViewStatus, boolean quoteSharingAllowed) {
            this.country = country;
            this.viewability = viewability;
            this.embeddable = embeddable;
            this.publicDomain = publicDomain;
            this.textToSpeechPermission = textToSpeechPermission;
            this.epub = epub;
            this.pdf = pdf;
            this.webReaderLink = webReaderLink;
            this.accessViewStatus = accessViewStatus;
            this.quoteSharingAllowed = quoteSharingAllowed;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getViewability() {
            return viewability;
        }

        public void setViewability(String viewability) {
            this.viewability = viewability;
        }

        public boolean isEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(boolean embeddable) {
            this.embeddable = embeddable;
        }

        public boolean isPublicDomain() {
            return publicDomain;
        }

        public void setPublicDomain(boolean publicDomain) {
            this.publicDomain = publicDomain;
        }

        public String getTextToSpeechPermission() {
            return textToSpeechPermission;
        }

        public void setTextToSpeechPermission(String textToSpeechPermission) {
            this.textToSpeechPermission = textToSpeechPermission;
        }

        public EpubBean getEpub() {
            return epub;
        }

        public void setEpub(EpubBean epub) {
            this.epub = epub;
        }

        public PdfBean getPdf() {
            return pdf;
        }

        public void setPdf(PdfBean pdf) {
            this.pdf = pdf;
        }

        public String getWebReaderLink() {
            return webReaderLink;
        }

        public void setWebReaderLink(String webReaderLink) {
            this.webReaderLink = webReaderLink;
        }

        public String getAccessViewStatus() {
            return accessViewStatus;
        }

        public void setAccessViewStatus(String accessViewStatus) {
            this.accessViewStatus = accessViewStatus;
        }

        public boolean isQuoteSharingAllowed() {
            return quoteSharingAllowed;
        }

        public void setQuoteSharingAllowed(boolean quoteSharingAllowed) {
            this.quoteSharingAllowed = quoteSharingAllowed;
        }

        public static class EpubBean {
            private boolean isAvailable;

            public EpubBean(boolean isAvailable) {
                this.isAvailable = isAvailable;
            }

            public boolean isIsAvailable() {
                return isAvailable;
            }

            public void setIsAvailable(boolean isAvailable) {
                this.isAvailable = isAvailable;
            }
        }

        public static class PdfBean {
            private boolean isAvailable;

            public PdfBean(boolean isAvailable) {
                this.isAvailable = isAvailable;
            }

            public boolean isIsAvailable() {
                return isAvailable;
            }

            public void setIsAvailable(boolean isAvailable) {
                this.isAvailable = isAvailable;
            }
        }
    }

    public static class SearchInfoBean {
        private String textSnippet;

        public SearchInfoBean(String textSnippet) {
            this.textSnippet = textSnippet;
        }

        public String getTextSnippet() {
            return textSnippet;
        }

        public void setTextSnippet(String textSnippet) {
            this.textSnippet = textSnippet;
        }
    }
}
