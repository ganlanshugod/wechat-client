package org.bana.wechat.pay.common;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WxPayUtilTest {

	@Test
	public void testDecodeRefundMessage() {
		Map<String,String> notifyMap = new HashMap<String,String>();
		notifyMap.put("nonce_str", "863ecc765d30c2e70be3f86793724ded");
		notifyMap.put("appid", "wx5bc259b375eb9572");
		notifyMap.put("mch_id", "1486632612");
		notifyMap.put("return_code", "SUCCESS");
		notifyMap.put("req_info", "L7+ktCxY2UQJgbEtI7PkTaT0Q9gMYxA3LjUTj8+Kba3NClP2vhyvaGuFvjuxidMbX8bAUC6+S7elAbDXaPGpdWN6gAEA9OAAH3mPE0z7mRgE9nhPmZ16gb1bsLUkn4mg3xcr/7+DbwH06p5cCs6g2I/AxIRww19zHeO4yAHmKZsQvZQQkbEzL+5PjaVBbpuoZP4lewbdhmfv/KwqiyhP8wTN+TdKh8MYzyLZfrS2M1Jv3PkpmfvxvSdyCZVs+FOSP8Bu13xKsqbu6urOGEOuovTHOvM/P+Fn9O5OmzBnWtLYKojnY/KAe5cw2rsVBQn97FkS8qe2pkhOg7PacdE0ruul2P/2Av0OMyMzMkWYvRdDtQNwoBx5Mdgz6H294yBceG/d9PF1pYnpOF6KmG4u09JQIik1zd+YfruxMzgxzO+kTt687M/Mqa2rqWw8fjJHkl4BzIgMcBfPkx/HujvIFE/e7y04VcKC8cyKcLsDFVYsiemQFEiDrwU/4CpTvtxie3wtF/rjnLdB/ZA1MgmWjPLaPPlDSOnQwLP85gB0XGAO82EJo/sAOCYspWob/pqMx8BDp6D6a7mMt7NyrVLwrr2LJTAC17akTmN4/06REbDWL6GOV5SorUkszwn9IjD2uJ1q7JxKGEqJaQ+DXk6NZK/5tCwDAp/L3mj6HhCRbRFbvkY1ktKHbJd0EpUBB+edjhkRVGB/cWCaCTEpC8fGYYBNicu7yjJVls5qpvyIrd6AdYUoYIuR4UwVHElIOGK5KFJqc0lkmic7gpejlFnuO62rhh10uTR63TTKOW9HW6MTrBMKI+3d5p4TxeM+DQDxPsizkoYCUy9GGQK4XZbhEqjV+UGiSlPzl+nb718fyxSXGC6qJZ+P5mXnZT9qgtcEmv/UgHkXXtYzQSKRvlM+GpJIcF6oHYu9VKCHkLSRwXvUl6OamUGs3E6w3VoyW1jVBA8qKHMz0wwjXUaWJh0HH75m/GyF0LOZ+ot8nXUVgFeJr/BOv/JaIyNdG7fBkpP8k7KqlDB+ndWez1y7C63iRSx/1SD9yjNJ3JV5TsLs1dFDTgqe+1vihfG0TYalIjZo");
		System.out.println(WxPayUtil.decodeRefundMessage(notifyMap,"qingdaobinhaidujiawangxindujia88"));
		System.out.println(notifyMap);
	}

}
