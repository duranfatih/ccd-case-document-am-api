package uk.gov.hmcts.reform.ccd.document.am.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.hmcts.reform.ccd.document.am.controller.advice.exception.UnauthorizedException;
import uk.gov.hmcts.reform.ccd.document.am.controller.endpoints.DocumentStoreFeignClient;

/**
 * Default endpoints per application.
 */
@RestController
public class CaseDocumentAmController {

    private static final Logger logger = LoggerFactory.getLogger(CaseDocumentAmController.class);

    @Autowired
    private DocumentStoreFeignClient documentFeignClient;

    /**
     * Root GET endpoint.
     *
     * <p>Azure application service has a hidden feature of making requests to root endpoint when
     * "Always On" is turned on.
     * This is the endpoint to deal with that and therefore silence the unnecessary 404s as a response code.
     *
     * @return Welcome message from the service.
     */
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ok("Welcome to CCD Case Document AM Controller");
    }

    @GetMapping("/cases")
    public ResponseEntity<List<String>> getCases() {
        throw new UnauthorizedException("This is an UnauthorizedException");
    }

    @RequestMapping("/swagger")
    public String index() {
        return "redirect:swagger-ui.html";
    }



}
