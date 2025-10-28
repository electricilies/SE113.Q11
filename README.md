# Hướng dẫn viết Unit Test Case

## 1. Unit Testing là gì? ##

- **Unit Testing** là một dạng kiểm thử mà trong đó, ta sẽ kiểm tra các đơn vị nhỏ nhất có trong mã nguồn (class, function, method, module,...) để xem từng chương trình, từng chức năng riêng rẽ có hoạt động đúng hay không. 
- **Unit Testing** là mức độ kiểm thử thấp nhất trong quy trình kiểm thử phần mềm và được thực hiện trước các bước kiểm thử khác như **Integration Testing** và **System Testing**. Vì vậy, việc thực hiện tốt quá trình Unit Testing sẽ giúp giảm tải cho các giai đoạn kiểm thử phía sau, cũng như đảm bảo sản phẩm chất lượng và hoàn thiện hơn. 
- Để ví dụ dễ hiểu, giả sử như ta đang muốn kiểm thử một chiếc xe đạp chẳng hạn, thì việc kiểm tra bánh xe (ruột bánh, vỏ lốp, nan hoa,...) sẽ thuộc về công đoạn Unit Test, việc kiểm tra hệ thống truyền động từ bánh xích tới bánh xe sẽ thuộc về Integration Test, việc đạp cho chiếc xe di chuyển sẽ là System Test và việc để cho người dùng thực sự đạp thử chiếc xe thuộc về công đoạn Acceptance Test.

## 2. So sánh Unit Test với các loại kiểm thử khác

| **Tiêu chí**            | **Unit Test**                            | **Integration Test**                  | **System Test**           | **Acceptance Test (UAT)**                    |
|-------------------------|------------------------------------------|---------------------------------------|---------------------------|----------------------------------------------|
| **Mức độ kiểm thử**     | Mức thấp nhất (từng hàm/class)           | Mức trung bình (các module kết hợp)   | Mức cao (toàn hệ thống)   | Cao nhất (toàn hệ thống + yêu cầu người dùng)|
| **Mục tiêu**            | Đảm bảo logic từng phần hoạt động đúng   | Kiểm tra sự tương tác giữa các module | Kiểm tra toàn bộ hệ thống | Xác nhận hệ thống đáp ứng yêu cầu nghiệp vụ  |
| **Phạm vi**             | Nhỏ (1 hàm, class)                       | Nhiều module giao tiếp                | Toàn bộ ứng dụng          | Toàn bộ ứng dụng trong môi trường thật       |
| **Thời điểm thực hiện** | Trong quá trình phát triển (early stage) | Sau Unit Test                         | Sau Integration Test      | Cuối cùng, trước khi triển khai chính thức   |
| **Tốc độ chạy test**    | Nhanh                                    | Trung bình                            | Chậm                      | Rất chậm (môi trường thật, dữ liệu thật)     |

## 3. Các Công cụ để viết Unit Test
- **Unit Test** tường được áp dụng sử dụng các công cụ như **JUnit, NUnit, PyTest, Jest**. Để phục vụ mục đích của bài lab 3 lần này, chúng ta sẽ sử dụng JUnit làm công cụ kiểm thử.

## 4. Cách viết Unit Test Case
- Ở ví dụ này, mình sẽ viết Unit Test Case dựa trên Template có sẵn đã thực hiện ở Lab 2 trước đó (Date Time Checker, Test hàm Date In Month).
- Một bảng Unit Test Case sẽ có dạng như ở dưới:

| |                                                | **TC_DM_1** | **TC_DM_2** | **TC_DM_3** | **TC_DM_4** | **TC_DM_5** |
|----------------------------------|------------------------------------------------|-----|---|----|---|---|
| **Condition** | **Month**                                      | | | | | |
|  | 0                                              | O |   |   |  |  |
|  | 1                                              |   | O | O |  |  |
|  | 2                                              |   |   | O |  |  |
|  | 4                                              |   |   |   | O |  |
|  | 12                                             |   |   |   |  | O |
|  | 13                                             |   | O |   |  |  |
|  | abc                                            |   |   |   |  | O |
| **Condition** | **Year**                                       | | | | | |
|  | 999                                            | O |   |   |  |  |
|  | 1000                                           |   |   | O |  |  |
|  | 2023                                           |   |   |   | O |  |
|  | 2024                                           |   |   |   |  | O |
|  | 3000                                           |   | O |   |  |  |
|  | 3001                                           |   |   |   |  | O |
|  | abc                                            |   |   |   | O |  |
| **Confirm** | **Return**                                     | | | | | |
|  | 31                                             |   | O |   |  |  |
|  | 30                                             |   |   | O |  |  |
|  | 29                                             |   |   |   | O |  |
|  | 28                                             |   |   |   |  | O |
|  | Error                                          | O |   |   |  |  |
| **Confirm** | **Exception**                                  | | | | | |
|  | T                                              |  O | O | O  |O  | O |
|  | F                                              |  |   |  |  |  |
| **Confirm** | **Log message**                                | | | | | |
|  | "input is out of range"                        | O | O | O |  |  |
|  | "input is invalid"                             |   |  |   | O | O  |
|  | "success"                                      |   |   |   |  | |
| **Result** | **Type (N: Normal, A: Abnormal, B: Boundary)** | A | A | A | A | A |
|  | **Passed/Failed**                              | P | P | P | P | P |
|  | **Executed Date**                              |   |   |   |  |  |

Hàng dọc sẽ có 3 nhóm chính: **Condition, Confirm** và **Result**.
- **Condition**: Điều kiện của Unit Test Case. Thường đây sẽ là các đầu vào của Test Case, ví dụ Test Case TC_DIM_O1 sẽ có Input Month = O, Year = 2O23.
- **Confirm**: Đầu ra mong muốn của Test Case đó. Tiếp tục với ví dụ ở trên, đầu ra mong muốn của chúng ta với Test Case đó là trả về lỗi, Exception = True và thông báo lỗi Input out of range.
- **Result**: Kết quả thực sự của Test Case sau khi thực hiện, bao gồm dạng Test Case (bình thường, bất thường, kiểm tra biên), kết quả kiểm tra (Vượt qua/Không vượt qua), Ngày thực hiện cũng như ID lỗi. Ví dụ như Test Case đầu tiên thuộc dạng bất thường, và hàm cần được kiểm thử đã vượt qua được Test Case đó.

Hàng ngang sẽ là các Test Case cùng với các giá trị tương ứng của mỗi Test Case ứng với các trường ở trên. Sau khi thiết kế các Test Case cho hàm, ta tiến hành lần lượt điền các Test Case vào bảng, Test Case có giá trị nào ở hàng nào thì ta sẽ đánh một dấu (ở đây là O) vào ô tương ứng ở đó.
