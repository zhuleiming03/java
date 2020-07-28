class WriteContextRepertory {

    private final static Integer LINE_COUNT = 3_000_000;

    String getContext() {
        StringBuilder contentStringBuilder = new StringBuilder();
        for (int i = 0; i < LINE_COUNT; i++) {
            contentStringBuilder.append("I Want to Eat Your Pancreas|君の膵臓をたべたい|我想吃掉你的胰脏|");
            contentStringBuilder.append(i);
            contentStringBuilder.append("\r\n");
        }
        return contentStringBuilder.toString();
    }
}
