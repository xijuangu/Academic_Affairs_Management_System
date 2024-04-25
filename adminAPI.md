# API文档：管理员管理

## 基本URL

``124.70.213.233:8080/admin``

## API列表

1. 添加管理员  
- URL: ~/add  
- 方法: POST  
- 请求体参数:  
    - admin_id (字符串): 管理员的唯一标识符。  
    - name (字符串): 管理员的名字。  
    - password (字符串): 管理员的密码。  

- 成功响应:  
    - 代码: 201（已创建）  
    - 内容: "Admin added successfully"  

- 错误响应:  
    - 代码: 400（请求错误）  
    - 内容: "Missing fields in request. Required fields: 'admin_id', 'name', 'password'" 或 "Invalid format for admin_id"  

- 请求示例:  
    ```json
    {
    "admin_id": "1",
    "name": "John Doe",
    "password": "securePassword123"
    }
    ```

2. 获取管理员信息
- URL: ~/get/{admin_id}
- 方法: GET
- URL参数:
    - admin_id (整数): 管理员的唯一标识符。  
- 成功响应:
    - 代码: 200（成功）
    - 内容: 管理员对象
- 错误响应:
    - 代码: 404（未找到）
    - 内容: 无
- 请求示例:
``124.70.213.233:8080/admin/get/1``

3. 更新管理员信息
- URL: ~/update
- 方法: POST
- 请求体参数:
    - admin_id (字符串): 管理员的唯一标识符。
    - name (字符串, 可选): 管理员的新名字。
    - password (字符串, 可选): 管理员的新密码。

- 成功响应:
    - 代码: 200（成功）
    - 内容: "Admin updated successfully"

- 错误响应:
    - 代码: 400（请求错误）  
    内容: "Admin ID is required for update." 或 "Invalid format for admin_id" 或 "No changes provided for update."

    - 代码: 404（未找到）  
    内容: "Admin not found."

- 请求示例:
    ```json
    {
    "admin_id": "1",
    "name": "Jane Doe"
    }
    ```

4. 删除管理员
- URL: ~/delete/{admin_id}
- 方法: DELETE
- URL参数:
    - admin_id (字符串): 管理员的唯一标识符。  
- 成功响应:
    - 代码: 200（成功）  
    内容: "Admin deleted successfully"
- 错误响应:
    - 代码: 400（请求错误）  
    内容: "Invalid format for admin_id"
    - 代码: 404（未找到）  
    内容: "Admin not found."  
- 请求示例:
``124.70.213.233:8080/admin/delete/1``

5. 获取所有管理员
- URL: /getAllAdmin
- 方法: GET
- 成功响应:  
代码: 200（成功）  
内容: 管理员对象列表  
- 错误响应: 无
- 请求示例:
``124.70.213.233:8080/admin/getAllAdmin``
