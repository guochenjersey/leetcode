package git.helper;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.TagCommand;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.*;
import org.eclipse.jgit.util.FS;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Slf4j
public class GitHelper {

    public static void main(String... args) throws IOException, GitAPIException {
        List<String> tags = Files.readAllLines(Paths.get("/Users/chenguo/Desktop/Release_after_05_01_2018"));
        tags.forEach(System.out::println);

        Git git = Git.open(new File("/Users/chenguo/Workspace/git-lab/MaxxTrader"));
        Files.createDirectory(Paths.get("/Users/chenguo/Workspace/docs"));

        tags.forEach(tagName -> {
            try {
                Path filePath = Paths.get("/Users/chenguo/Workspace/docs/" + tagName);
                Files.createFile(filePath);
                git.checkout()
                        .setName(tagName)
                        .call();
                Iterable<RevCommit> logs = git.log().call();
                Iterator<RevCommit> logIterator = logs.iterator();
                while (logIterator.hasNext()) {
                    RevCommit commit = logIterator.next();

                    PersonIdent committerIdent = commit.getCommitterIdent();
                    Date when = committerIdent.getWhen();
                    TimeZone timeZone = committerIdent.getTimeZone();
                    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(when.toInstant(), timeZone.toZoneId());
                    if (zonedDateTime.isAfter(ZonedDateTime.of(2018, 5, 1, 0, 0, 0, 0, ZoneId.of("America/New_York")))) {
                        Files.write(filePath, Arrays.asList(commit.getId().toString()
                                + "\n" + commit.getFullMessage() + "\n"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                    }
                }
            } catch (GitAPIException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}

//class SshTransportConfigCallback implements TransportConfigCallback {
//
//    private final ThreadLocal<SshSessionFactory> sshSessionFactory = ThreadLocal.withInitial(() -> new JschConfigSessionFactory() {
//        @Override
//        protected void configure(OpenSshConfig.Host hc, Session session) {
//            session.setConfig("StrictHostKeyChecking", "no");
//        }
//
//        @Override
//        protected JSch createDefaultJSch(FS fs) throws JSchException {
//            JSch jSch = super.createDefaultJSch(fs);
//            jSch.addIdentity("/Users/chenguo/.ssh/id_rsa", "password".getBytes());
//            return jSch;
//        }
//    });
//
//    @Override
//    public void configure(Transport transport) {
//        SshTransport sshTransport = (SshTransport) transport;
//        sshTransport.setSshSessionFactory(sshSessionFactory.get());
//    }
//}