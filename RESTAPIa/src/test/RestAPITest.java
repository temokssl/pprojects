package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;
import com.google.gson.Gson;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.json.JSONArray;
import main.java.models.PostModel;
import main.java.models.UserModel;
import main.java.utilities.APIUtil;
import main.java.utilities.JSONUtil;
import main.java.utilities.RandomUtil;

public class RestAPITest {
	
		private Gson gson = new Gson();
		
		private ISettingsFile TEST_DATA = new JsonSettingsFile("test-data.json");
		private ISettingsFile CONFIG_DATA = new JsonSettingsFile("config-data.json");
		
		
		private String POSTS_ENDPOINT = CONFIG_DATA.getValue("/POSTS_ENDPOINT").toString();
		private String USERS_ENDPOINT = CONFIG_DATA.getValue("/USERS_ENDPOINT").toString();
		private String API = CONFIG_DATA.getValue("/API").toString();
		
		private int CORRECT_USERID = Integer.parseInt(TEST_DATA.getValue("/CORRECT_USERID").toString());
		private int CORRECT_ID = Integer.parseInt(TEST_DATA.getValue("/CORRECT_ID").toString());
		private int WRONG_ID = Integer.parseInt(TEST_DATA.getValue("/WRONG_ID").toString());
		private int USER_ID = Integer.parseInt(TEST_DATA.getValue("/USER_ID").toString());
		private int POST_USER_ID = Integer.parseInt(TEST_DATA.getValue("/POST_USER_ID").toString());
		private int RANDOM_STRING_LENGTH = Integer.parseInt(TEST_DATA.getValue("/RANDOM_STRING_LENGTH").toString());
		private int ALPHABETIC_RANGE_SIZE = Integer.parseInt(TEST_DATA.getValue("/ALPHABETIC_RANGE_SIZE").toString());
		private int CASE_FIVE_ID = Integer.parseInt(TEST_DATA.getValue("/CASE_FIVE_ID").toString());
		private String USER_DATA_TEST_FILE = TEST_DATA.getValue("/USER_DATA_TEST_FILE").toString();
		private String EMPTY_BODY = TEST_DATA.getValue("/EMPTY_BODY").toString();
		
		private String NEW_TITLE = RandomUtil.getRandomString(RANDOM_STRING_LENGTH,ALPHABETIC_RANGE_SIZE);
		private String NEW_BODY = RandomUtil.getRandomString(RANDOM_STRING_LENGTH,ALPHABETIC_RANGE_SIZE);
		private int STATUS_CODE_200 = 200;
		private int STATUS_CODE_201 = 201;
		private int STATUS_CODE_404 = 404;
		
		@Test
		public void restAPITest() {
	
				HttpResponse<JsonNode> allPostResponse = APIUtil.get(API+POSTS_ENDPOINT);
				Assert.assertEquals(allPostResponse.getStatus(),STATUS_CODE_200,"Status code isn't 200.");
				Assert.assertTrue(JSONUtil.isItJson(allPostResponse),"The list in response body isn't json.");
				JSONArray allPostResponseJsonArray = allPostResponse.getBody().getArray();
				List<PostModel> postModelList = Arrays.asList(gson.fromJson(allPostResponseJsonArray.toString() ,PostModel[].class ));
				List<Integer> postsIdList = new ArrayList<Integer>();
				for(int i=0;i<postModelList.size();i++) {postsIdList.add(postModelList.get(i).getId());}
				Assert.assertTrue(Ordering.natural().isStrictlyOrdered(postsIdList),"Posts aren't sorted ascending (by id).");
				
				
				HttpResponse<JsonNode> responseNnine = APIUtil.get(API+POSTS_ENDPOINT+"/"+CORRECT_ID);
				Assert.assertEquals(responseNnine.getStatus(),STATUS_CODE_200,"Status code isn't 200.");
				String responseBodyNnine = responseNnine.getBody().toString();
				PostModel postModelNnine = gson.fromJson(responseBodyNnine, PostModel.class);
				Assert.assertEquals(postModelNnine.getUserId(),Integer.valueOf(CORRECT_USERID)," userId isn't 10.");
				Assert.assertEquals(postModelNnine.getId(),Integer.valueOf(CORRECT_ID),"id isn't 99.");
				Assert.assertNotNull(postModelNnine.getTitle(),"title is empty.");
				Assert.assertNotNull(postModelNnine.getBody(),"body is empty.");
				
				
				HttpResponse<JsonNode> emptyResponse = APIUtil.get(API+POSTS_ENDPOINT+"/"+WRONG_ID);
				String emptyResponseBody = emptyResponse.getBody().toString();
				Assert.assertEquals(emptyResponse.getStatus(),STATUS_CODE_404,"Status code isn't 404.");
				Assert.assertTrue(emptyResponseBody.equals(EMPTY_BODY),"Response body isn't empty.");
				
				
				PostModel postModel = new PostModel(POST_USER_ID,null,NEW_TITLE,NEW_BODY);
				String requestBody = gson.toJson(postModel);
				HttpResponse<JsonNode> postResponse = APIUtil.post(API+POSTS_ENDPOINT,requestBody);
				Assert.assertEquals(postResponse.getStatus(),STATUS_CODE_201,"Status code isn't 201.");
				String postResponseBody = postResponse.getBody().toString();
				PostModel newPostModel = gson.fromJson(postResponseBody, PostModel.class);
				Assert.assertEquals(newPostModel.getUserId(),Integer.valueOf(POST_USER_ID),"Not the same userId.");
				Assert.assertEquals(newPostModel.getTitle(),NEW_TITLE,"Not the same title.");
				Assert.assertEquals(newPostModel.getBody(),NEW_BODY,"Not the same body.");
				
				
				HttpResponse<JsonNode> userResponse = APIUtil.get(API+USERS_ENDPOINT);
				UserModel JsonFileUserModel = JSONUtil.getObjectFromJsonFile(USER_DATA_TEST_FILE,UserModel.class);
				JSONArray userResponseArray = userResponse.getBody().getArray();
				List<UserModel> usersList = Arrays.asList(gson.fromJson(userResponseArray.toString() ,UserModel[].class ));
				UserModel responseUserModel =  usersList.get(CASE_FIVE_ID-1);
				Assert.assertEquals(userResponse.getStatus(),STATUS_CODE_200,"Status code isn't 200.");
				Assert.assertTrue(JSONUtil.isItJson(userResponse),"The list in response body isn't json.");
				Assert.assertEquals(responseUserModel,JsonFileUserModel ,"Not the same data in id=5.");
				
				
				HttpResponse<JsonNode> newUserResponse = APIUtil.get(API+USERS_ENDPOINT+"/"+USER_ID);
				Assert.assertEquals(newUserResponse.getStatus(),STATUS_CODE_200,"Status code isn't 200.");
				String newUserResponseBody = newUserResponse.getBody().getObject().toString();
				UserModel newUserResponseUserModel = gson.fromJson(newUserResponseBody , UserModel.class);
				Assert.assertEquals(newUserResponseUserModel,JsonFileUserModel ,"Not the same data in id=5.");
		}
}