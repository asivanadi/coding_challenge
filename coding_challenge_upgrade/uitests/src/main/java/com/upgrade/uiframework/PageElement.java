package com.upgrade.uiframework;

public class PageElement {
    private final ElementType elementType;
    private final String element;

    public PageElement(final ElementType elementType, final String element) {
        this.elementType = elementType;
        this.element = element;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public String getElement() {
        return element;
    }
}
