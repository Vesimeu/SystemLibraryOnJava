package com.library.system.book;

// Декоратор для добавления метаданных в электронную книгу
public class EBookWithMetadata extends Book {
    protected EBook ebook;
    private String metadata;

    public EBookWithMetadata(EBook ebook, String metadata) {
        super(ebook.title, ebook.author);
        this.ebook = ebook;
        this.metadata = metadata;
    }

    @Override
    public String getDetails() {
        return ebook.getDetails() + ", Metadata: " + metadata;
    }
}
