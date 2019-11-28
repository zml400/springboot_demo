package guru.springframework.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false)
public class EmployeeServiceImpl {
}
