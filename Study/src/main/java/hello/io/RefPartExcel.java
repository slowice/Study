package hello.io;

import lombok.Data;

@Data
public class RefPartExcel {
    @ExcelColumn("原零件号")
    private String partNo;

    @ExcelColumn("原零件名称")
    private String partName;

    @ExcelColumn("参考零件号")
    private String refPartNo;

    @ExcelColumn("参考零件名称")
    private String refPartName;;

    @ExcelColumn("长")
    private String length;

    @ExcelColumn("宽")
    private String width;


}
