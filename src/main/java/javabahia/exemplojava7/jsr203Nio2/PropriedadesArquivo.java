/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javabahia.exemplojava7.jsr203Nio2;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

/**
 *
 * @author otavio
 */
public class PropriedadesArquivo {

    public static void propriedadesPath(Path path) throws Exception {

        System.out.println("Tamanho do arquivo em bytes " + Files.size(path));
        System.out.println("é diretório " + Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));
        System.out.println("é regular " + Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS));
        System.out.println("é escondigo pelo SO " + Files.isHidden(path));
        System.out.println("Modificacao " + Files.getLastModifiedTime(path, LinkOption.NOFOLLOW_LINKS));
        System.out.println("Dono " + Files.getOwner(path, LinkOption.NOFOLLOW_LINKS));


        System.out.println("\n \n \n Basicos Atributos do arquivo \n \n \n ");
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

        System.out.println("criacao: " + attr.creationTime());
        System.out.println("ultmo acesso: " + attr.lastAccessTime());
        System.out.println("ultima modificacao: " + attr.lastModifiedTime());

        System.out.println("e diretorio: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("arquivo regular: " + attr.isRegularFile());
        System.out.println("simbolico link: " + attr.isSymbolicLink());
        System.out.println("tamanho: " + attr.size());

        System.out.println("\n \n \n Dos Atributos do arquivo \n \n \n ");

        DosFileAttributes dosAttr = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("somente leitura " + dosAttr.isReadOnly());
        System.out.println("escondido " + dosAttr.isHidden());
        System.out.println("arquivo " + dosAttr.isArchive());
        System.out.println("arquivo de sistema " + dosAttr.isSystem());

//PosixFileAttributeView
//FileOwnerAttributeView
//AclFileAttributeView 
//UserDefinedFileAttributeView 
    }
}
