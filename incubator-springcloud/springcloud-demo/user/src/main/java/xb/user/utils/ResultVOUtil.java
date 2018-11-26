package xb.user.utils;


import xb.user.VO.ResultVO;
import xb.user.enums.ResultEnum;

public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode("0");
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode("0");
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setData(resultEnum.getCode());
        return resultVO;
    }
}
