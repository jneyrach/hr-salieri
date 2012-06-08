
class PackageUtils {

    public String createDirectoryPackage(String packageName) {
    
        def String directoryName = packageName.replace('.', '/')

        return directoryName
    }

}
