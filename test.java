public class GeneratePriKey {
    public static void main(String[] args) throws IOException {
        String currentPath = System.getProperty("user.dir");
        try (InputStream inputStream = new FileInputStream(currentPath + File.separator + args[0]);
             OutputStream outputStream = new FileOutputStream(currentPath + File.separator + "apiclient_key_after_handle.txt")) {
            List<String> rawPriKeyLineList = IOUtils.readLines(inputStream, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            rawPriKeyLineList.stream().skip(1).limit(rawPriKeyLineList.size() - 2).forEach(sb::append);
            String result = sb.toString();
            IOUtils.write(result, outputStream, StandardCharsets.UTF_8);
            System.out.println(result);
        }
    }
}
