package printer;

/**
 * ��ӡ���õ�ֽ�Žӿ�
 */
public interface Paper {
    public static final String newLine="\r\n";

    /**
     * ��ֽ��������������
     * @param c
     */
    public void putInChar(char c);
    /**
     * �õ������ֽ�ŵ�����
     */
    public String getContent();


}
