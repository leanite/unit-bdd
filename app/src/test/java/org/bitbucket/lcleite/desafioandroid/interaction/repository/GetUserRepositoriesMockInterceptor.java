package org.bitbucket.lcleite.desafioandroid.interaction.repository;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by leandro on 26/12/2017.
 */


public class GetUserRepositoriesMockInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String responseString = getResponseMock();
        Response response = new Response.Builder()
            .code(200)
            .message(responseString)
            .request(chain.request())
            .protocol(Protocol.HTTP_1_0)
            .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
            .addHeader("content-type", "application/json")
            .build();

        return response;
    }

    private String getResponseMock(){
        return "[\n" +
                "  {\n" +
                "    \"id\": 45549780,\n" +
                "    \"name\": \"ansible-aws-test\",\n" +
                "    \"full_name\": \"elastic/ansible-aws-test\",\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"elastic\",\n" +
                "      \"id\": 6764390,\n" +
                "      \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/elastic\",\n" +
                "      \"html_url\": \"https://github.com/elastic\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "      \"type\": \"Organization\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"private\": false,\n" +
                "    \"html_url\": \"https://github.com/elastic/ansible-aws-test\",\n" +
                "    \"description\": \"testing\",\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/ansible-aws-test\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/elastic/ansible-aws-test/deployments\",\n" +
                "    \"created_at\": \"2015-11-04T15:55:05Z\",\n" +
                "    \"updated_at\": \"2015-11-20T17:05:01Z\",\n" +
                "    \"pushed_at\": \"2015-11-04T16:24:02Z\",\n" +
                "    \"git_url\": \"git://github.com/elastic/ansible-aws-test.git\",\n" +
                "    \"ssh_url\": \"git@github.com:elastic/ansible-aws-test.git\",\n" +
                "    \"clone_url\": \"https://github.com/elastic/ansible-aws-test.git\",\n" +
                "    \"svn_url\": \"https://github.com/elastic/ansible-aws-test\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 128,\n" +
                "    \"stargazers_count\": 1,\n" +
                "    \"watchers_count\": 1,\n" +
                "    \"language\": null,\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_projects\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"forks_count\": 0,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"archived\": false,\n" +
                "    \"open_issues_count\": 0,\n" +
                "    \"license\": null,\n" +
                "    \"forks\": 0,\n" +
                "    \"open_issues\": 0,\n" +
                "    \"watchers\": 1,\n" +
                "    \"default_branch\": \"master\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 48370306,\n" +
                "    \"name\": \"ansible-beats\",\n" +
                "    \"full_name\": \"elastic/ansible-beats\",\n" +
                "    \"owner\": {\n" +
                "      \"login\": \"elastic\",\n" +
                "      \"id\": 6764390,\n" +
                "      \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/elastic\",\n" +
                "      \"html_url\": \"https://github.com/elastic\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "      \"type\": \"Organization\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"private\": false,\n" +
                "    \"html_url\": \"https://github.com/elastic/ansible-beats\",\n" +
                "    \"description\": \"Ansible Beats Role\",\n" +
                "    \"fork\": false,\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/ansible-beats\",\n" +
                "    \"forks_url\": \"https://api.github.com/repos/elastic/ansible-beats/forks\",\n" +
                "    \"keys_url\": \"https://api.github.com/repos/elastic/ansible-beats/keys{/key_id}\",\n" +
                "    \"collaborators_url\": \"https://api.github.com/repos/elastic/ansible-beats/collaborators{/collaborator}\",\n" +
                "    \"teams_url\": \"https://api.github.com/repos/elastic/ansible-beats/teams\",\n" +
                "    \"hooks_url\": \"https://api.github.com/repos/elastic/ansible-beats/hooks\",\n" +
                "    \"issue_events_url\": \"https://api.github.com/repos/elastic/ansible-beats/issues/events{/number}\",\n" +
                "    \"events_url\": \"https://api.github.com/repos/elastic/ansible-beats/events\",\n" +
                "    \"assignees_url\": \"https://api.github.com/repos/elastic/ansible-beats/assignees{/user}\",\n" +
                "    \"branches_url\": \"https://api.github.com/repos/elastic/ansible-beats/branches{/branch}\",\n" +
                "    \"tags_url\": \"https://api.github.com/repos/elastic/ansible-beats/tags\",\n" +
                "    \"blobs_url\": \"https://api.github.com/repos/elastic/ansible-beats/git/blobs{/sha}\",\n" +
                "    \"git_tags_url\": \"https://api.github.com/repos/elastic/ansible-beats/git/tags{/sha}\",\n" +
                "    \"git_refs_url\": \"https://api.github.com/repos/elastic/ansible-beats/git/refs{/sha}\",\n" +
                "    \"trees_url\": \"https://api.github.com/repos/elastic/ansible-beats/git/trees{/sha}\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/ansible-beats/statuses/{sha}\",\n" +
                "    \"languages_url\": \"https://api.github.com/repos/elastic/ansible-beats/languages\",\n" +
                "    \"stargazers_url\": \"https://api.github.com/repos/elastic/ansible-beats/stargazers\",\n" +
                "    \"contributors_url\": \"https://api.github.com/repos/elastic/ansible-beats/contributors\",\n" +
                "    \"subscribers_url\": \"https://api.github.com/repos/elastic/ansible-beats/subscribers\",\n" +
                "    \"subscription_url\": \"https://api.github.com/repos/elastic/ansible-beats/subscription\",\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/ansible-beats/commits{/sha}\",\n" +
                "    \"git_commits_url\": \"https://api.github.com/repos/elastic/ansible-beats/git/commits{/sha}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/ansible-beats/comments{/number}\",\n" +
                "    \"issue_comment_url\": \"https://api.github.com/repos/elastic/ansible-beats/issues/comments{/number}\",\n" +
                "    \"contents_url\": \"https://api.github.com/repos/elastic/ansible-beats/contents/{+path}\",\n" +
                "    \"compare_url\": \"https://api.github.com/repos/elastic/ansible-beats/compare/{base}...{head}\",\n" +
                "    \"merges_url\": \"https://api.github.com/repos/elastic/ansible-beats/merges\",\n" +
                "    \"archive_url\": \"https://api.github.com/repos/elastic/ansible-beats/{archive_format}{/ref}\",\n" +
                "    \"downloads_url\": \"https://api.github.com/repos/elastic/ansible-beats/downloads\",\n" +
                "    \"issues_url\": \"https://api.github.com/repos/elastic/ansible-beats/issues{/number}\",\n" +
                "    \"pulls_url\": \"https://api.github.com/repos/elastic/ansible-beats/pulls{/number}\",\n" +
                "    \"milestones_url\": \"https://api.github.com/repos/elastic/ansible-beats/milestones{/number}\",\n" +
                "    \"notifications_url\": \"https://api.github.com/repos/elastic/ansible-beats/notifications{?since,all,participating}\",\n" +
                "    \"labels_url\": \"https://api.github.com/repos/elastic/ansible-beats/labels{/name}\",\n" +
                "    \"releases_url\": \"https://api.github.com/repos/elastic/ansible-beats/releases{/id}\",\n" +
                "    \"deployments_url\": \"https://api.github.com/repos/elastic/ansible-beats/deployments\",\n" +
                "    \"created_at\": \"2015-12-21T12:21:37Z\",\n" +
                "    \"updated_at\": \"2017-09-19T17:50:49Z\",\n" +
                "    \"pushed_at\": \"2016-05-05T18:29:14Z\",\n" +
                "    \"git_url\": \"git://github.com/elastic/ansible-beats.git\",\n" +
                "    \"ssh_url\": \"git@github.com:elastic/ansible-beats.git\",\n" +
                "    \"clone_url\": \"https://github.com/elastic/ansible-beats.git\",\n" +
                "    \"svn_url\": \"https://github.com/elastic/ansible-beats\",\n" +
                "    \"homepage\": null,\n" +
                "    \"size\": 28,\n" +
                "    \"stargazers_count\": 1,\n" +
                "    \"watchers_count\": 1,\n" +
                "    \"language\": \"Ruby\",\n" +
                "    \"has_issues\": true,\n" +
                "    \"has_projects\": true,\n" +
                "    \"has_downloads\": true,\n" +
                "    \"has_wiki\": true,\n" +
                "    \"has_pages\": false,\n" +
                "    \"forks_count\": 0,\n" +
                "    \"mirror_url\": null,\n" +
                "    \"archived\": false,\n" +
                "    \"open_issues_count\": 0,\n" +
                "    \"license\": null,\n" +
                "    \"forks\": 0,\n" +
                "    \"open_issues\": 0,\n" +
                "    \"watchers\": 1,\n" +
                "    \"default_branch\": \"master\"\n" +
                "  }\n" +
                "]";
    }
}
